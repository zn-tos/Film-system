package com.example.demo.mapper;

import com.example.demo.entity.catefilm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface catefilmMapper {
    //查看电影类型
    @Select("select cate.`name` from cate,catefilm where catefilm.filmid=#{filmid} and catefilm.classid=cate.id")
    public List<String> selectById(String filmid);
    //插入条目
    @Insert("insert into catefilm values(#{catefilm.classid},#{catefilm.filmid})")
    public int insert(@Param("catefilm") catefilm catefilm);
    //更新条目
    @Update("update catefilm set classid=#{classid} where filmid=#{filmid}")
    public int update(String classid,String filmid);
    //删除条目
    @Delete("delete from catefilm where filmid=#{filmid}")
    public int deleteById(String filmid);
}
