package com.wyu.pojo;

public class clb {
    private String username;
    private String result;

    public clb(String username, String result) {
        this.username = username;
        this.result = result;
    }

    public clb() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "clb{" +
                "username='" + username + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
