package com.example.demo.entity;

public class director {
    private String birthday;
    private String filmnumber;
    private String idnumber;//Primary key
    private String identity;

    public director(String birthday,String filmnumber,String idnumber,String identity){
        this.birthday = birthday;
        this.filmnumber = filmnumber;
        this.idnumber = idnumber;
        this.identity = identity;
    }
    public String getBirthday(){
        return birthday;
    }
    public String getFilmnumber(){
        return filmnumber;
    }
    public String getIdnumber(){
        return idnumber;
    }
    public String getIdentity(){
        return identity;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setFilmnumber(String filmnumber){
        this.filmnumber = filmnumber;
    }
    public void setIdnumber(String idnumber){
        this.idnumber = idnumber;
    }
    public void setIdentity(String identity){
        this.identity = identity;
    }

}
