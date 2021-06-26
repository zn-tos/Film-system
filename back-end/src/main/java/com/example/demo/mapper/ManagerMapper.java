package com.example.demo.mapper;

import com.example.demo.entity.Manager;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface ManagerMapper {

    @Select("select * from manager where username = #{username}")
    Manager selectByUsername(String username);

   // @Select("select * from manager")
   // ArrayList<User> selectAll();

    @Insert("insert into manager values(#{manager.username},#{manager.password},#{manager.name},#{manager.telephone})")
    boolean insert(Manager manager);

    @Update("update manager set password = #{password} where username = #{username}")
    boolean update_password(String username,String password);

    @Update("update manager set name = #{name} where username = #{username}")
    boolean update_name(String username,String name);

    @Update("update manager set telephone = #{telephone} where username = #{username}")
    boolean update_telephone(String username,String telephone);

    @Delete("delete from manager where username = #{username}")
    boolean delete(String username);

}