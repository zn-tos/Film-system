package com.example.demo.service;
import com.example.demo.entity.director;
import com.example.demo.mapper.directorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class directorService {
    @Autowired
    directorMapper directorMapper;


}
