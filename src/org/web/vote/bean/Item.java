package org.web.vote.bean;

import java.io.Serializable;

public class Item implements Serializable{
    private int id;
    private int oid;
    private int sid;
    private int uid;

    public Item(int id, int oid, int sid, int uid) {
        this.id = id;
        this.oid = oid;
        this.sid = sid;
        this.uid = uid;
    }

    public Item(int oid, int sid, int uid) {
        this.oid = oid;
        this.sid = sid;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", oid=" + oid +
                ", sid=" + sid +
                ", uid=" + uid +
                '}';
    }
}
