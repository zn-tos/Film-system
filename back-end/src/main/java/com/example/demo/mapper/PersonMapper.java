package com.example.demo.mapper;

import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PersonMapper {

    //添加条目
    public int addPerson(Person person);
    //删除条目
    public int deleteByUsername(String name);           //删除
    //更新条目
    public int updatePerson(Person person);          //修改
    //根据username查询
    public Person findPersonByUsername(String username);  //姓名查询
    //删除全部条目
    public void deleteAll();                                             //删除所有的信息
    //查询全部
    List<Person> findAllPerson();
}
