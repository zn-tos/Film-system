package com.example.demo.entity;

public class catefilm {
    private String classid;//Primary key
    private String filmid;
    public catefilm(String classid,String filmid){
        this.classid = classid;
        this.filmid = filmid;
    }
    public String getfilmid(){
        return filmid;
    }
    public String getclassid(){
        return classid;
    }
    public void setfilmid(String filmid){
        this.filmid = filmid;
    }
    public void setclassid(String classid){
        this.classid = classid;
    }

}
