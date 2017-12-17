package org.web.vote.dao;

import org.web.vote.bean.Subject;
import org.web.vote.bean.User;
import org.web.vote.util.SimpDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends UtilDao implements UserDao {
    private List list = new ArrayList();
    public User u = null;
    @Override
    public User getUser(User user) {
        try {
            System.out.println("------------------"+user.toString());
            String sql = "SELECT * FROM vote_user WHERE vu_name = '"+user.getUname()+"' AND vu_pwd='"+user.getUpwd()+"'";
            super.rs = super.getUser(sql);
            System.out.println(rs.toString()+"!!!!!!!!!!!!!!!!!!!!!!!");
            if (super.rs.next()){
                u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public int addUser(User user) {
        int b = 0;
        String sql = "INSERT INTO `vote_db`." +
                "`vote_user` (`vu_name`,`vu_pwd`,`vu_status`,`vu_phome`,`vu_age`," +
                "`vu_sex`,`vu_registrationDate`,`vu_hobbies`) " +
                "VALUES('"+user.getUname()+"','"+user.getUpwd()+"', '"+user.getStatus()+"', '"+user.getPhome()+"',"+user.getAge()+","+user.getSex()+", " +
                "'"+ SimpDate.simpDate(new Date())+"', '"+user.getHobbies()+"' )";
        try {
            System.out.println("--------------------------------------------");
            System.out.println(sql);
            b = super.insert(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

}
