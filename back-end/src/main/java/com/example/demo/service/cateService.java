package com.example.demo.service;

import com.example.demo.entity.cate;
import com.example.demo.entity.film;
import com.example.demo.mapper.cateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class cateService {
    @Autowired
    cateMapper cateMapper;
//根据类别查询
    public List<film> selectByName(String name){
        return cateMapper.selectByName(name);
    }
    //根据类别查询
    public String selectByName1(String name){
        return cateMapper.selectByName1(name);
    }
    public List<String> selectAllName(){
        return cateMapper.selectAllName();
    }

    public List<cate> selectAll() {
        return cateMapper.selectAll();
    }

    public int insert(cate cate){
        return cateMapper.insert(cate);
    }

    public int delete(cate cate){
        return cateMapper.delete(cate);
    }


}
