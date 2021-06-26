package com.example.demo.controller;

import com.example.demo.entity.film;
import com.example.demo.entity.staff;
import com.example.demo.service.filmService;
import com.example.demo.service.staffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class staffController {

    @Autowired
    private staffService staffService;

    @GetMapping("/findAllstaff")
    public List<staff> findAllstaff(){
        return staffService.findAllstaff();
    }

    @GetMapping("/selectByDirectName")
    public List<film> selectByDirectName(@RequestParam("name") String name){
        return staffService.selectByDirectName(name);
    }
    @GetMapping("/selectByActorName")
    public List<film> selectByActorName(@RequestParam("name") String name){
        return staffService.selectByActorName(name);
    }
    @GetMapping("/selectByAsideName")
    public List<film> selectByAsideName(@RequestParam("name") String name){
        return staffService.selectByAsideName(name);
    }
}
