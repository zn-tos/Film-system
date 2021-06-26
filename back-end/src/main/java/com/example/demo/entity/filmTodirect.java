package com.example.demo.entity;

public class filmTodirect {
    private String directname;
    private String directident;

    public filmTodirect(String directname, String directident){
        this.directname = directname;
        this.directident = directident;
    }
    public String getDirectname(){
        return directname;
    }
    public String getDirectident(){
        return directident;
    }

    public void setDirectname(String directname){
        this.directname = directname;
    }
    public void setDirectident(String directident){
        this.directident = directident;
    }

}
