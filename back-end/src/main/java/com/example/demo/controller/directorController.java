package com.example.demo.controller;

import com.example.demo.entity.director;
import com.example.demo.service.directorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class directorController {
    @Autowired
    private directorService directorService;


}
