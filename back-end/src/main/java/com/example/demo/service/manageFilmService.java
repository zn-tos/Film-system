package com.example.demo.service;

import com.example.demo.entity.campanyfilm;
import com.example.demo.entity.catefilm;
import com.example.demo.entity.film;
import com.example.demo.entity.manageFilm;
import com.example.demo.mapper.manageFilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class manageFilmService {
    @Autowired
    manageFilmMapper manageFilmMapper;
    @Autowired
    filmService filmService;
    @Autowired
    cateService cateService;
    @Autowired
    catefilmService catefilmService;
    @Autowired
    campanyService campanyService;
    @Autowired
    campanyfilmService campanyfilmService;
    public int insert(manageFilm manageFilm){
        filmService.insert(new film(manageFilm.getName(),manageFilm.getId(),manageFilm.getBirthday(),manageFilm.getTime(),
                manageFilm.getLang(),manageFilm.getCountry(),manageFilm.getBrief(),manageFilm.getScore(),manageFilm.getPic()));
        String campanyid=campanyService.selectByName1(manageFilm.getCampany());
        campanyfilmService.insert(new campanyfilm(manageFilm.getId(),campanyid));
        String classid=cateService.selectByName1(manageFilm.getCate());
        catefilmService.insert(new catefilm(classid,manageFilm.getId()));
        return 1;
    }
    public int update(manageFilm manageFilm){
        filmService.update(manageFilm.getName(),manageFilm.getId(),manageFilm.getBirthday(),manageFilm.getTime(),
                manageFilm.getLang(),manageFilm.getCountry(),manageFilm.getBrief(),manageFilm.getScore(),manageFilm.getPic());
        String campanyid=campanyService.selectByName1(manageFilm.getCampany());
        campanyfilmService.updatename(manageFilm.getId(), campanyid);
        String classid=cateService.selectByName1(manageFilm.getCate());
        catefilmService.update(classid,manageFilm.getId());
        return 1;
    }
    public int delete(String id){
        filmService.deleteById(id);
        campanyfilmService.deleteById(id);
        catefilmService.deleteById(id);
        return 1;
    }

}
