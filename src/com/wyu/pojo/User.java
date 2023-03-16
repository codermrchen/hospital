package com.wyu.pojo;

public class User {
    private String username;
    private String password;
    private String csrq;
    private String xb;
    private String city;
    private String zp;

    public User(String username, String password, String csrq, String xb, String city, String zp) {
        this.username = username;
        this.password = password;
        this.csrq = csrq;
        this.xb = xb;
        this.city = city;
        this.zp = zp;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", csrq='" + csrq + '\'' +
                ", xb='" + xb + '\'' +
                ", city='" + city + '\'' +
                ", zp='" + zp + '\'' +
                '}';
    }
}
