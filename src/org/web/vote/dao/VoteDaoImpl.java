package org.web.vote.dao;

import org.web.vote.bean.Item;
import org.web.vote.bean.Option;
import org.web.vote.bean.Subject;
import org.web.vote.bean.Vote;
import org.web.vote.log.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDaoImpl extends UtilDao implements VoteDao{
    public int count = 0;
    public int id;
    @Override
    public List<Subject> getListAll() {
        List list = new ArrayList();
        sql ="SELECT a.sid,a.stitle,a.stype,a.optioncount,b.usercount FROM " +
                "(SELECT vs.`vs_id` sid,vs.`vs_title` stitle, vs.`vs_type` stype,COUNT(vo.`vo_option`) optioncount" +
                " FROM vote_option AS vo,vote_subject AS vs WHERE vo.`vs_id`=vs.`vs_id` GROUP BY vo.`vs_id`)AS a," +
                " (SELECT vs.`vs_id` sid,COUNT(DISTINCT(vi_id)) usercount " +
                " FROM vote_item AS vi RIGHT JOIN vote_subject vs ON vs.`vs_id`=vi.`vs_id` GROUP BY vs.`vs_id`)AS b" +
                " WHERE a.sid=b.sid";
        try {
            super.rs = super.getLisrAll(sql);
            while(rs.next()){
                id = rs.getInt(1);
                Subject sub = new Subject(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
                list.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Option> getListAll(int id) {
        List list = new ArrayList();
        sql = "SELECT * FROM vote_option WHERE vs_id = '"+id+"'";
        try {
            rs = super.query(sql);
            while (rs.next()){
                Option option = new Option(rs.getInt(1),
                        rs.getString(2),rs.getInt(1));
                System.out.println(option.toString()+"Option.toString");
                list.add(option);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString()+"+++++++++++++++Dao");
        return list;
    }

    @Override
    public void toVote(Vote vote) {
        sql = "INSERT INTO vote_item(vo_id,vs_id,vu_id) VALUES(408,102,1);";

    }

    public int[] getVote(int[] oid,int uid){
        String sql1 = null;
        int[] oids = new int[oid.length];
        for(int i = 0;i<oid.length;i++){
            sql1 = "SELECT *FROM vote_item WHERE vo_id="+oid[i]+" AND vu_id="+uid+"";
            try {
                rs = super.query(sql1);
                if(rs.next()){
                    System.out.println("##############"+sql1);
                   continue;
                }else {
                    oids[i] = oid[i];
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return oids;
    }

   /* public Option getOption(int id) {
        String sql1 = "SELECT * FROM vote_option WHERE vo_id ="+id;
        try {
            rs = super.query(sql1);
            if (rs.next()){
                Option option = new Option(rs.getInt(1),
                        rs.getString(2),rs.getInt(1));
                System.out.println(option.toString()+"Option.toString");
              return option;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    @Override
    public int doVote(Vote vote) {
        int b = 0;
        sql = "INSERT INTO vote_item(vo_id, vs_id, vu_id) VALUES ";
        int length = sql.length();
        int[] oids = this.getVote(vote.getOids(),vote.getUid());
        for (int i = 0; i<oids.length;i++){
            System.out.println(vote.getOids()[i]+""+vote.getUid());
            if(oids[i]>0) {
                if (i < oids.length - 1) {
                    sql += "(" + oids[i] + "," + vote.getSid() + "," + vote.getUid() + "),";
                } else {
                    sql += "(" + oids[i] + "," + vote.getSid() + "," + vote.getUid() + ")";
                }
            }else {

            }
                System.out.println(sql);
        }
        if (length==sql.length()){
            return 1;
        }
        try {
            b = super.insert(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
    public int maxId(){
        sql = "SELECT MAX(vs_id) FROM vote_subject;";
        int maxId = 0;
        try {
            rs = query(sql);
            if (rs.next()){
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }

    @Override
    public int addNewVote(Subject subject) {
        sql = "INSERT INTO `vote_db`.`vote_subject` ( `vs_title`, `vs_type`) VALUES( '"+subject.getStitle()+"', "+subject.getStype()+")";
        int b = 0;
        try {
            b = insert(sql);
            if (b > 0 && this.maxId()>0){
                sql = "insert into vote_option(vo_option,vs_id) values ";
                for (int i = 0;i < subject.getOptions().length;i++){
                    if (i<subject.getOptions().length-1){
                        sql += "('"+subject.getOptions()[i]+"',"+maxId()+"),";
                    }else {
                        sql += "('"+subject.getOptions()[i]+"',"+maxId()+")";
                    }

                }
                b = insert(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

   /* @Override
    public int getUserCount(int vs_id) {

        sql = "SELECT COUNT(vu_id) FROM vote_item  WHERE vs_id = '"+vs_id+"'";
        try {
            rs = super.query(sql);
            while (rs.next()){
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int getOptionCount(int vs_id) {
        sql = "SELECT COUNT(vo_id) FROM vote_option WHERE vs_id='"+vs_id+"'";
        try {
            super.rs = super.query(sql);
            while (rs.next()){
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }*/
}
