package com.example.demo.service;

import com.example.demo.entity.actor;
import com.example.demo.mapper.actorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class actorService {
    actorMapper actorMapper;
    //查询全部演员

}
