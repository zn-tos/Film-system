package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class campany {
    private String city;
    private String name;
    private String id;//Primary key
    private String brief;
    private String pic;
    public campany(String city,String name,String id,String brief,String pic){
        this.city = city;
        this.name = name;
        this.id = id;
        this.brief = brief;
        this.pic = pic;
    }
    public String getCity(){
        return city;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getBrief(){
        return brief;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setBrief(String brief){
        this.brief = brief;
    }

}
