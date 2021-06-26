package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cate {
    private String id;//Primary key
    private String name;
    public cate(String id,String name){
        this.id = id;
        this.name = name;
    }
    /*
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
*/
}
