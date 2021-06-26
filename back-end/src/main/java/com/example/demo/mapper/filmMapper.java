package com.example.demo.mapper;
import com.example.demo.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface filmMapper {
    List<film> findAll();

    @Select("select * from film where id=#{id}")
    public film findbyid(String id);

   // @Select("select name from film where id=#{id}")
    //public film findnamebyid(String id);
    //根据名称查询
    @Select("select DISTINCT film.* from film where film.name like '%${name}%'")
    public List<film> selectByName(String name);
    //根据名称查询电影导演
    @Select("select DISTINCT staff.`name`,director.identity from film,director,staff " +
            "where film.id like '%${id}%' and film.id=director.filmnumber and director.idnumber=staff.id;")
    public List<filmTodirect> selectBydirect(String id);
    //根据名称查询电影演员
    @Select("select DISTINCT staff.`name`,actor.role from film,actor,staff \n" +
            "where film.id like '%${id}%' and film.id=actor.filmnumber and actor.idnumber=staff.id;")
    public List<filmToact> selectByact(String id);
    //根据名称查询电影旁白
    @Select("select DISTINCT staff.`name`,aside.role, aside.brief from film,aside,staff \n" +
            "where film.id like '%${id}%' and film.id=aside.filmnumber and aside.idnumber=staff.id;")
    public List<filmToaside> selectByaside(String id);

    //添加条目
    @Insert("insert into film values(#{film.name},#{film.id},#{film.birthday}," +
            "#{film.time},#{film.lang},#{film.country},#{film.brief},#{film.score},#{film.pic})")
    public int insert(@Param("film")  film film);

    //更新简介
    @Update("update film set brief=#{brief} where name=#{name}")
    public int updateBrief(String name,String brief);
    //更新评分
    @Update("update film set score=#{score} where name=#{name}")
    public int updateScore(String name,String score);
    @Update("update film set name=#{name},birthday=#{birthday},time=#{time},lang=#{lang}," +
            "country=#{country},brief=#{brief},score=#{score},pic=#{pic} where id=#{id}")
    public int update(String name,String id,String birthday,String time,String lang,
                      String country,String brief,String score,String pic);

    //删除条目
    @Delete("delete from film where id=#{id}")
    public int deleteById(String id);           //删除
    //删除全部条目
    @Delete("delete from film")
    public void deleteAll();         //删除所有的信息
}
