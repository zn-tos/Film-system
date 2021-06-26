package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.mapper.filmMapper;

import java.util.List;

@Service
@Transactional
public class filmService {
    @Autowired
    filmMapper filmMapper;

    public List<film> getfilms(){
        return filmMapper.findAll();
    }
    //根绝id查
    public film findbyid(String id){return filmMapper.findbyid(id);}
    //根据名字查
    public List<film> selectByName(String name){
        return filmMapper.selectByName(name);
    }
    //根据名称查询电影导演
    public List<filmTodirect> selectBydirect(String id){
        return filmMapper.selectBydirect(id);
    }
    //根据名称查询电影演员
    public List<filmToact> selectByact(String id){
        return filmMapper.selectByact(id);
    }
    //根据名称查询电影旁白
    public List<filmToaside> selectByaside(String id){
        return filmMapper.selectByaside(id);
    }

    //添加条目
    public int insert(film film){
        return filmMapper.insert(film);
    }

    //更新简介
    public int updateBrief(String name,String brief){
        return filmMapper.updateBrief(name,brief);
    }
    //更新评分
    public int updateScore(String name,String score){
        return filmMapper.updateScore(name,score);
    }
    //更新所有
    public int update(String name,String id,String birthday,String time,String lang,
                      String country,String brief,String score,String pic){
        return filmMapper.update(name,id,birthday,time,lang, country,brief, score, pic);
    }
    //删除条目
    public int deleteById(String id) {
        return filmMapper.deleteById(id);
    }
    //删除全部条目
    public void deleteAll() {
        filmMapper.deleteAll();
    }
}
