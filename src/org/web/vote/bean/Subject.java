package org.web.vote.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject implements Serializable{
    private int sid;
    private String stitle;
    private int stype;
    private int optionCount;
    private int userCount;
    private List<Option> olist = new ArrayList<Option>();

    public Subject(int sid, String stitle, int stype, List<Option> olist) {
        this.sid = sid;
        this.stitle = stitle;
        this.stype = stype;
        this.olist = olist;
    }

    private String[] options;

    public Subject(String stitle ,int stype, String[] options) {
        this.stitle = stitle;
        this.stype = stype;
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public Subject() {
    }

    public Subject(String stitle, int stype, int optionCount, int userCount) {
        this.stitle = stitle;
        this.stype = stype;
        this.optionCount = optionCount;
        this.userCount = userCount;
    }


    public Subject(int sid, String stitle, int stype, int userCount) {
        this.sid = sid;
        this.stitle = stitle;
        this.stype = stype;
        this.userCount = userCount;
    }

    public Subject(int sid, String stitle, int stype) {
        this.sid = sid;
        this.stitle = stitle;
        this.stype = stype;
    }

    public Subject(int sid, String stitle, int stype, int optionCount, int userCount) {
        this.sid = sid;
        this.stitle = stitle;
        this.stype = stype;
        this.optionCount = optionCount;
        this.userCount = userCount;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public int getStype() {
        return stype;
    }

    public void setStype(int stype) {
        this.stype = stype;
    }

    public int getOptionCount() {
        return optionCount;
    }

    public void setOptionCount(int optionCount) {
        this.optionCount = optionCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public List<Option> getOlist() {
        return olist;
    }

    public void setOlist(List<Option> olist) {
        this.olist = olist;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "sid=" + sid +
                ", stitle='" + stitle + '\'' +
                ", stype=" + stype +
                ", optionCount=" + optionCount +
                ", userCount=" + userCount +
                ", olist=" + olist +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}
