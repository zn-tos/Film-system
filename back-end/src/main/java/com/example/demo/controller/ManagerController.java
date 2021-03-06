package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

@RestController
public class ManagerController {
    private String savePath="F://ZYVue//src//assets//";
    private String image="";
    @Autowired
    private ManagerService managerService;
    @Autowired
    private campanyService campanyService;
    @Autowired
    private cateService cateService;

    @Autowired
    private filmService filmService;
    @Autowired
    private catefilmService catefilmService;
    @Autowired
    private campanyfilmService campanyfilmService;
    @Autowired
    private manageFilmService manageFilmService;

    @GetMapping("/getcampanyName")
    public List<String> getcampanyName(){
        return campanyService.selectAllName();
    }
    @GetMapping("/getcampany")
    public List<campany> getcampany(){
        return campanyService.selectAll();
    }
    @PostMapping("/updatecampany")
    public int updatecampany(@RequestBody campany campany){
        return  campanyService.insert(campany);
    }
    @PostMapping("/deletecampany")
    public int deletecampany(@RequestBody campany campany){
        return campanyService.delete(campany);
    }

    @GetMapping("/getcateName")
    public List<String> getcateName(){
        return cateService.selectAllName();
    }
    @GetMapping("/getcate")
    public List<cate> getcate(){
        return cateService.selectAll();
    }
    @PostMapping("/updatecate")
    public int updatecate(@RequestBody cate cate){
        return  cateService.insert(cate);
    }
    @PostMapping("/deletecate")
    public int deletecate(@RequestBody cate cate){
        return cateService.delete(cate);
    }


    @GetMapping("/getfilm")
    public List<managergetfilm> getfilm(){
        List<managergetfilm> ret=new ArrayList<>();
        List<film> films= filmService.getfilms();
        for(film ff:films){
            List<String> cates=catefilmService.selectById(ff.getId());
            List<String> campanys=campanyfilmService.selectById(ff.getId());
            managergetfilm data=new managergetfilm();
            data.setBirthday(ff.getBirthday());
            data.setBrief(ff.getBrief());
            data.setCountry(ff.getCountry());
            data.setId(ff.getId());
            data.setLang(ff.getLang());
            data.setPic(ff.getPic());
            data.setName(ff.getName());
            data.setScore(ff.getScore());
            data.setTime(ff.getTime());
            data.setCate(cates);
            data.setCampany(campanys);
            ret.add(data);
        }
        return ret;
    }

    @PostMapping("/updatefilm")
    public int updatefilm(@RequestBody manageFilm manageFilm){
      ///  if(filmService.selectByName(manageFilm.getName())!=null){
        //    return manageFilmService.update(manageFilm);
       // }
       // else{
            return manageFilmService.insert(manageFilm);
      //  }
    }

    @PostMapping("/deletefilm")
    public int daletefilm(@RequestBody managergetfilm managergetfilm){
        return manageFilmService.delete(managergetfilm.getId());
    }

    @PostMapping("/manage/login")
    public Result login(@RequestBody Req1 test)
    {
        System.out.println(test.getUsername()+" "+test.getPassword());
        if(test.getUsername()==null||test.getPassword()==null) return new Result(401,"????????????","");

        //??????????????????
        Subject subject= SecurityUtils.getSubject();
        String password="";
        try {
            //???????????????????????????
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //???????????????new BigInteger????????????
            password = new BigInteger(1, md.digest(test.getPassword().getBytes())).toString(16);//16???????????????????????????16??????,8??????8??????,????????????
            System.out.println(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //????????????????????????
        UsernamePasswordToken token=new UsernamePasswordToken(test.getUsername(), password);
        try {
            subject.login(token);
            Login1 loginVO=new Login1();
            //??????token???????????????uuid
            //??????jwt??????????????????????????????jwt token,jwt token???????????????????????????
            loginVO.setToken(UUID.randomUUID().toString());
            if(managerService.selectByUsername(test.getUsername())==null) return new Result(401,"????????????","");
            loginVO.setManager(managerService.selectByUsername(test.getUsername()));
            return new Result(200,"success",loginVO);

        } catch (UnknownAccountException e) {
            System.out.println("false");
            return new Result(401,"????????????","");
        }catch (IncorrectCredentialsException e){
            System.out.println("false");
            return new Result(401,"????????????","");
        }catch (AuthenticationException e){
            System.out.println("false");
            return new Result(401,"????????????","");
        }
    }

    /**
     * ??????????????????
     * @param map
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    public Result upload(@RequestParam Map<String,String> map,@RequestParam("file") MultipartFile file) {
        System.out.println("????????????????????????");
        Map<String,Object> m = new HashMap<>();
        String isbn = "";
        if(map.size() >0){
            try{
                isbn = map.get("isbn").toString();
            }catch (Exception e){
                return new Result(500,"fail","");
            }
        }
        //??????????????????
        String suffix = file.getOriginalFilename().substring
                (file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        //??????UUID?????????????????????
        String filename = UUID.randomUUID().toString().replaceAll("-","") + "." + suffix;
        image=filename;
        try {
            //???????????????????????????
            file.transferTo(new File(savePath + filename));
            System.out.println(savePath + filename);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500,"fail","");
        }
        return new Result(200,"success","");
    }

}
