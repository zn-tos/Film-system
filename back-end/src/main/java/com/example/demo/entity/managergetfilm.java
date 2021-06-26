package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class managergetfilm {
    private String name;
    private String id;
    private String birthday;
    private String time;
    private String lang;
    private String country;
    private String brief;
    private String score;
    private String pic;
    private List<String> cate;
    private List<String> campany;
    public managergetfilm(String name,String id,String birthday,String time, String lang,
                          String country,String brief,String score,String pic,List<String> cate,List<String> campany){
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.time = time;
        this.lang = lang;
        this.country = country;
        this.brief = brief;
        this.score = score;
        this.pic = pic;
        this.cate = cate;
        this.campany =campany;
    }
    public managergetfilm(){

    }
    /*public film getFilm(){return film;}
    public List<String> getCate(){
        return cate;
    }
    public List<String> getCampany(){
        return campany;
    }
    public void setFilm(film film){this.film = film;}
    public void setCate(List<String> cate){
        this.cate = cate;
    }
    public void setCampany(List<String> campany){
        this.campany = campany;
    }*/

}
