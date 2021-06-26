package com.example.demo.service;

import com.example.demo.entity.campanyfilm;
import com.example.demo.mapper.campanyfilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class campanyfilmService {
    @Autowired
    campanyfilmMapper campanyfilmMapper;

    public List<String> selectById(String filmid){
        return campanyfilmMapper.selectById(filmid);
    }
    public int insert(campanyfilm campanyfilm){
        return campanyfilmMapper.insert(campanyfilm);
    }

    public int updatename(String filmid,String campanyid){
        return campanyfilmMapper.updatename(filmid,campanyid);
    }

    public int deleteById(String filmid){
        return campanyfilmMapper.deleteById(filmid);
    }

}
