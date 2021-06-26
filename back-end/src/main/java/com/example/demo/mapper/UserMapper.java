package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User findUserByUsername(String username);        //姓名查询

    List<User> findAllUser(); //查询全部

    public void deleteAll();//删除全部条目

    public  int addUser(User user);                  //增加

    public  int deleteByUsername(String username);         //删除

    public int updateUser(User user);               //修改


}
