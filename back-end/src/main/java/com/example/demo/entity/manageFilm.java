package com.example.demo.entity;

public class manageFilm {
    private String name;
    private String id;
    private String birthday;
    private String time;
    private String lang;
    private String country;
    private String brief;
    private String score;
    private String pic;
    private String cate;
    private String campany;
    public manageFilm(String name,String id,String birthday,String time, String lang,
                String country,String brief,String score,String pic,String cate,String campany){
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
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getBirthday(){
        return birthday;
    }
    public String getTime(){
        return time;
    }
    public String getLang(){
        return lang;
    }
    public String getCountry(){
        return country;
    }
    public String getBrief(){
        return brief;
    }
    public String getScore(){
        return score;
    }
    public String getPic(){
        return pic;
    }
    public String getCate(){
        return cate;
    }
    public String getCampany(){
        return campany;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setLang(String lang){
        this.lang = lang;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setBrief(String brief){
        this.brief = brief;
    }
    public void setScore(String score){
        this.score = score;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public void setCate(String cate){
        this.cate = cate;
    }
    public void setCampany(String campany){
        this.campany = campany;
    }
}
