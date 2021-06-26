package com.example.demo.service;

import com.example.demo.entity.film;
import com.example.demo.entity.staff;
import com.example.demo.mapper.filmMapper;
import com.example.demo.mapper.staffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class staffService {
    @Autowired
    staffMapper staffMapper;

    public List<staff> findAllstaff(){
        return staffMapper.findAllstaff();
    }
    //根据名字查询导演作品
    public List<film> selectByDirectName(String name){
        return staffMapper.selectByDirectName(name);
    }
    //根据名字查询参演作品
    public List<film> selectByActorName(String name){
        return staffMapper.selectByActorName(name);
    }
    //根据名字查询配音作品
    public List<film> selectByAsideName(String name){
        return staffMapper.selectByAsideName(name);
    }

}
