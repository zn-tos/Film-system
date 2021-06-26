package com.example.demo.controller;

import com.example.demo.entity.film;
import com.example.demo.entity.campany;
import com.example.demo.service.campanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campany")
public class campanyController {
    @Autowired
    private campanyService campanyService;

    @GetMapping("/getall")
    public List<campany> selectall(){
        return campanyService.selectAll();
    }

    @GetMapping("/selectByName")
    public List<film> selectByName(@RequestParam("name") String name){
        return campanyService.selectByName(name);
    }
//根据id找电影
    @GetMapping("/selectByid")
    public List<film> selectByid(@RequestParam("id") String id){
        return campanyService.selectByid(id);
    }
    //根据ID找公司信息
    @GetMapping("/findcamByid")
    public campany findByid(@RequestParam("id") String id){
        return campanyService.findcamByid(id);
    }
}
