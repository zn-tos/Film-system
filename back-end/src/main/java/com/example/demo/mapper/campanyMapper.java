package com.example.demo.mapper;

import com.example.demo.entity.campany;
import com.example.demo.entity.film;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface campanyMapper {

    //查询全部
    @Select("select * from campany")
    public List<campany> selectAll();
    //查询全部公司名称
    @Select("select name from campany")
    public List<String> selectAllName();

    //根据名称查询
    @Select("select distinct film.* from film,campany,campanyfilm \n" +
            "where  campany.name like '%${name}%' and campany.id=campanyfilm.campanyid and campanyfilm.filmid=film.id;")
    public List<film> selectByName(String name);

    @Select("select  campany.id from campany where campany.name like '%${name}%' ")
    public String selectByName1(String name);


    @Select("select distinct film.* from film,campany,campanyfilm \n" +
            "where  campany.id=#{id} and campany.id=campanyfilm.campanyid and campanyfilm.filmid=film.id;")
    public List<film> selectByid(String id);


    @Select("select * from campany \n" +
            "where  campany.id=#{id} ;")
    public campany findcamByid(String id);

    //添加条目
    @Insert("insert into campany values(#{campany.city},#{campany.name}," +
            "#{campany.id},#{campany.brief},#{campany.pic}) ")
    public int insert(@Param("campany") campany campany);

    //更新条目
    @Update("update campany set brief=#{brief} where id=#{id}")
    public int updateBrief(String id,String brief);          //修改

    //删除条目
    @Delete("delete from campany where id=#{id}")
    public int deleteById(String id);           //删除
    //删除条目
    @Delete("delete from campany where id=#{campany.id}")
    public int delete(@Param("campany") campany campany);           //删除

    //删除全部条目
    @Delete("delete from campany")
    public void deleteAll();         //删除所有的信息

}
