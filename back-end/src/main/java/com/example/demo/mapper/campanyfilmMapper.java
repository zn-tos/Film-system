package com.example.demo.mapper;

import com.example.demo.entity.campanyfilm;
import com.example.demo.entity.film;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface campanyfilmMapper {
    //查询全部
    @Select("select * from campanyfilm ")
    public List<film> selectAll();
    //查询电影所在出品公司
    @Select("select campany.`name` from campany,campanyfilm where campanyfilm.filmid=#{filmid} \n" +
            "and campanyfilm.campanyid=campany.id;")
    public List<String> selectById(String filmid);

    //添加条目
    @Insert("insert into campanyfilm values(#{campanyfilm.filmid},#{campanyfilm.campanyid}) ")
    public int insert(@Param("campanyfilm") campanyfilm campanyfilm);

    //更新条目
    @Update("update campanyfilm set campanyid=#{campanyid} where filmid=#{filmid}")
    public int updatename(String filmid,String campanyid);          //修改

    //删除条目
    @Delete("delete from campanyfilm where filmid=#{filmid}")
    public int deleteById(String filmid);           //删除
    //删除全部条目
    @Delete("delete from campanyfilm")
    public void deleteAll();         //删除所有的信息

}
