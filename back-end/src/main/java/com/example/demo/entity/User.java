package com.example.demo.entity;


public class User {
    private String username;//primary key
    private String pass;
    public User(String username,String pass){
        this.username = username;
        this.pass = pass;
    }
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
