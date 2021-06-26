package com.example.demo.controller;

import com.example.demo.entity.film;
import com.example.demo.service.cateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/cate")
public class cateController {
    @Autowired
    private com.example.demo.service.cateService cateService;

    @GetMapping("/selectByName")
    public List<film> selectByName(@RequestParam("name") String name){
        return cateService.selectByName(name);
    }

}
