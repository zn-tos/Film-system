package com.example.demo.entity;

public class campanyfilm {
    private String filmid;//Primary key
    private String campanyid;
    public campanyfilm(String filmid,String campanyid){
        this.filmid = filmid;
        this.campanyid = campanyid;
    }
    public String getCampanyid(){
        return campanyid;
    }
    public String getFilmid(){
        return filmid;
    }
    public void setCampanyid(String campanyid){
        this.campanyid = campanyid;
    }
    public void setFilmid(String filmid){
        this.filmid = filmid;
    }

}
