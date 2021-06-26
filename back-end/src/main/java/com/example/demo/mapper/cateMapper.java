package com.example.demo.mapper;
import com.example.demo.entity.cate;
import com.example.demo.entity.film;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface cateMapper {
    //查询全部
    @Select("select * from cate")
    public List<cate> selectAll();

    //根据类别查询
    @Select("select DISTINCT film.* from cate,film,catefilm where cate.name like '%${name}%' and cate.id=catefilm.classid and catefilm.filmid=film.id")
    public List<film> selectByName(String name);
    //查询全部名称
    @Select("select name from cate")
    public List<String> selectAllName();


    @Select("select cate.id from cate where cate.name like '%${name}%' ")
    public String selectByName1(String name);
    //添加条目
    @Insert("insert into cate values(#{cate.id},#{cate.name}) ")
    public int insert(@Param("cate")cate cate);

    //更新条目
    @Update("update cate set name=#{name} where id=#{id}")
    public int updatename(String id,String name);          //修改

    //删除条目
    @Delete("delete from cate where id=#{cate.id}")
    public int delete(@Param("cate") cate cate);           //删除

    //删除条目
    @Delete("delete from cate where id=#{id}")
    public int deleteById(String id);           //删除
    //删除全部条目
    @Delete("delete from cate")
    public void deleteAll();         //删除所有的信息

}
