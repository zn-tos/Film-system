package com.example.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PersonMapper personMapper;

    public User getUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }
    public List<User> getUsers(){
        return userMapper.findAllUser();
    }

    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public int deleteUserByUsername(String username){
        if(personMapper.findPersonByUsername(username)!=null) personMapper.deleteByUsername(username);
        return userMapper.deleteByUsername(username);
    }

    public void deleteAll(){
        userMapper.deleteAll();
    }
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    //分页查询
    public PageInfo<User> getPageInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.findAllUser();
        PageInfo<User> PageInfo = new PageInfo<User>(users);
        return PageInfo;
    }
}
