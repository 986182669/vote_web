package org.web.vote.bean;

import java.io.Serializable;

public class User implements Serializable{
    private int uid;
    private String uname;
    private String upwd;
    private int status;
    private int age;
    private int sex;
    private String phome;
    private String registrationDate;
    private String hobbies;

    public User(String uname, String upwd, int status, int age, int sex, String phome, String registrationDate, String hobbies) {
        this.uname = uname;
        this.upwd = upwd;
        this.status = status;
        this.age = age;
        this.sex = sex;
        this.phome = phome;
        this.registrationDate = registrationDate;
        this.hobbies = hobbies;
    }

    public User() {
    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User(String uname, String upwd, int status) {
        this.uname = uname;
        this.upwd = upwd;
        this.status = status;
    }

    public User(int uid, String uname, String upwd, int status) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhome() {
        return phome;
    }

    public void setPhome(String phome) {
        this.phome = phome;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setregistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", status=" + status +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phome='" + phome + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
