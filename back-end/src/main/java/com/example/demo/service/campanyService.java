package com.example.demo.service;

import com.example.demo.entity.campany;
import com.example.demo.entity.film;
import com.example.demo.mapper.campanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class campanyService {
    @Autowired
    campanyMapper campanyMapper;

    //查询全部
    public List<campany> selectAll(){
        return campanyMapper.selectAll();
    }
    //根据角色查询
    public List<film> selectByName(String name){
        return campanyMapper.selectByName(name);
    }
    //查询全部名称
    public List<String> selectAllName(){
        return campanyMapper.selectAllName();
    }

    //根据角色查询
    public String selectByName1(String name){
        return campanyMapper.selectByName1(name);
    }
    //根据campanyID查dianying

    public List<film> selectByid(String id){return campanyMapper.selectByid(id);};
    //根据campanyID查campany
    public campany findcamByid(String id){return campanyMapper.findcamByid(id);}
    //删除条目
    public int deleteById(String id) {
        return campanyMapper.deleteById(id);
    }
    //删除全部条目
    public void deleteAll() {
        campanyMapper.deleteAll();
    }

    public int insert(campany campany){
        return campanyMapper.insert(campany);
    }
    public int delete(campany campany){
        return campanyMapper.delete(campany);
    }
}
