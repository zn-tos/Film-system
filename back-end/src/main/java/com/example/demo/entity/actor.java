package com.example.demo.entity;

public class actor {
    private String birthday;
    private String filmnumber;//Primary key
    private Integer idnumber;//Primary key
    private String role;
    public actor(String birthday,String filmnumber,Integer idnumber,String role){
        this.birthday = birthday;
        this.filmnumber = filmnumber;
        this.idnumber = idnumber;
        this.role = role;
    }
    public String getBirthday(){
        return birthday;
    }
    public String getFilmnumber(){
        return filmnumber;
    }
    public Integer getIdnumber(){
        return idnumber;
    }
    public String getRole(){
        return role;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setFilmnumber(String filmnumber){
        this.filmnumber = filmnumber;
    }
    public void setIdnumber(Integer idnumber){
        this.idnumber = idnumber;
    }
    public void setRole(String identity){
        this.role = role;
    }

}
