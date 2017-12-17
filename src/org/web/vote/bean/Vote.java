package org.web.vote.bean;

import java.io.Serializable;
import java.util.Arrays;

public class Vote implements Serializable{
    private int sid;
    private int uid;
    private int[] oids;

    public Vote() {
    }

    public Vote(int sid, int uid, int[] oids) {
        this.sid = sid;
        this.uid = uid;
        this.oids = oids;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int[] getOids() {
        return oids;
    }

    public void setOids(int[] oids) {
        this.oids = oids;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", oids=" + Arrays.toString(oids) +
                '}';
    }
}
