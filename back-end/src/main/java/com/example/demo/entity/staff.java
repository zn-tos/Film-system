package com.example.demo.entity;

public class staff {
    private String name;
    private String id;//Primary key

    public staff(String name,String id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setId(String id){
        this.id = id;
    }

}
