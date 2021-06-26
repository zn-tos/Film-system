package com.example.demo.service;

import com.example.demo.entity.catefilm;
import com.example.demo.mapper.catefilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class catefilmService {
    @Autowired
    catefilmMapper catefilmMapper;

    public List<String> selectById(String filmid){
        return catefilmMapper.selectById(filmid);
    }
    //添加条目
    public int insert(catefilm catefilm){
        return catefilmMapper.insert(catefilm);
    }
    public int update(String classid,String filmid){
        return catefilmMapper.update(classid,filmid);
    }
    public int deleteById(String filmid){
        return catefilmMapper.deleteById(filmid);
    }
}
