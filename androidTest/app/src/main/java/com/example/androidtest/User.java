package com.example.androidtest;

public class User {

    private String userName, pass;

    public User() {
    }

    public User(String un, String p) {
        userName = un;
        pass = p;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
