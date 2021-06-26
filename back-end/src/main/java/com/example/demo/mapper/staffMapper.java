package com.example.demo.mapper;
import com.example.demo.entity.Person;
import com.example.demo.entity.film;
import com.example.demo.entity.staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface staffMapper {
    //查询全部
    @Select("select * from staff;")
    List<staff> findAllstaff();

    //根据名字查询导演作品
    @Select("select DISTINCT film.* from staff,film,director where staff.name like '%${name}%' and staff.id=director.idnumber and director.filmnumber=film.id")
    public List<film> selectByDirectName(String name);

    //根据名字查询参演作品
    @Select("select DISTINCT film.* from staff,film,actor where staff.name like '%${name}%' and staff.id=actor.idnumber and actor.filmnumber=film.id")
    public List<film> selectByActorName(String name);

    //根据名字查询配音作品
    @Select("select DISTINCT film.* from staff,film,aside where staff.name like '%${name}%' and staff.id=aside.idnumber and aside.filmnumber=film.id")
    public List<film> selectByAsideName(String name);
}
