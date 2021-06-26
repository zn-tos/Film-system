package com.example.demo.entity;

public class filmToact {
    private String actorname;
    private String actorident;

    public filmToact(String actorname, String actorident){
        this.actorname = actorname;
        this.actorident = actorident;
    }

    public String getActorname(){
        return actorname;
    }
    public String getActorident(){
        return actorident;
    }

    public void setActorname(String actorname){
        this.actorname = actorname;
    }
    public void setActorident(String actorident){
        this.actorident = actorident;
    }

}
