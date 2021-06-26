package com.example.demo.entity;

public class filmToaside {
    private String asidename;
    private String asideident;
    private String asidebrief;

    public filmToaside( String asidename,String asidebrief,String asideident){
        this.asidename = asidename;
        this.asideident = asideident;
        this.asidebrief = asidebrief;

    }

    public String getAsidename(){
        return asidename;
    }
    public String getAsideident(){
        return asideident;
    }
    public String getAsidebrief(){
        return asidebrief;
    }


    public void setAsidename(String asidename){
        this.asidename = asidename;
    }
    public void setAsideident(String asideident){
        this.asideident = asideident;
    }
    public void setAsidebrief(String asidebrief){
        this.asidebrief = asidebrief;
    }

}

