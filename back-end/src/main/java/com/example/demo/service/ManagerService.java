package com.example.demo.service;

import com.example.demo.mapper.ManagerMapper;
import com.example.demo.entity.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    public Manager selectByUsername(String username){
        return managerMapper.selectByUsername(username);
    }

   // public ArrayList<User> selectAll(){
     //   return managerMapper.selectAll();
  //  }

    public boolean insert(Manager manager){
        return managerMapper.insert(manager);
    }

    public boolean update_password(String username,String password){
        return managerMapper.update_password(username,password);
    }

    public boolean update_name(String username,String name){
        return managerMapper.update_name(username,name);
    }

    public boolean update_telephone(String username,String telephone){
        return managerMapper.update_telephone(username,telephone);
    }

    public boolean delete(String username){
        return managerMapper.delete(username);
    }
}