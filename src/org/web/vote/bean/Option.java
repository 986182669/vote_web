package org.web.vote.bean;

public class Option {
    private int oid;
    private String option;
    private int sid;

    public Option() {
    }

    public Option(int oid, String option, int sid) {
        this.oid = oid;
        this.option = option;
        this.sid = sid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Option{" +
                "oid=" + oid +
                ", option='" + option + '\'' +
                ", sid=" + sid +
                '}';
    }
}
