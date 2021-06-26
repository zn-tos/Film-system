package com.example.demo.entity;
import com.example.demo.entity.Manager;

import java.io.Serializable;
public class Login1 {
    private String token;
    private Manager manager;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
