package com.example.demo.controller;
import com.example.demo.entity.film;
import com.example.demo.entity.filmToact;
import com.example.demo.entity.filmToaside;
import com.example.demo.entity.filmTodirect;
import com.example.demo.service.filmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class filmController {
    @Autowired
    private filmService filmService;

    @GetMapping("/getFilms")
    public List<film> getfilms(){
        return filmService.getfilms();
    }

   // public film findbyid(String id){return filmMapper.findbyid(id);}
    @GetMapping("/findByid")
    public film findByid(@RequestParam("id") String id){
        return filmService.findbyid(id);
    }
    //根据名字查电影
    @GetMapping("/selectByName")
    public List<film> selectByName(@RequestParam("name") String name){
        return filmService.selectByName(name);
    }

    @GetMapping("/selectBydirect")
    public List<filmTodirect> selectBydirect(@RequestParam("id") String id){return filmService.selectBydirect(id);}

    @GetMapping("/selectByact")
    public List<filmToact> selectByact(@RequestParam("id") String id){
        return filmService.selectByact(id);
    }

    @GetMapping("/selectByaside")
    public List<filmToaside> selectByaside(@RequestParam("id") String id){
        return filmService.selectByaside(id);
    }
}
