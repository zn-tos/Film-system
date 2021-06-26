package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.entity.User;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PersonService {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    UserMapper userMapper;

    public int addPerson(Person person){
        if(userMapper.findUserByUsername(person.getUsername())==null) {      //信息不存在于user
            userMapper.addUser(new User(person.getUsername(),"888888"));
        }
        return personMapper.addPerson(person);
    }

    public int deletePersonByUsername(String username){
        return personMapper.deleteByUsername(username);
    }


    public void deleteAll(){
        personMapper.deleteAll();
    }

    public int updatePerson(Person person){
        return personMapper.updatePerson(person);
    }

    public List<Person> getPersons(){
        return personMapper.findAllPerson();
    }

    public Person getPersonByUsername(String username){
        return personMapper.findPersonByUsername(username);
    }
    //分页查询
    public PageInfo<Person> getPageInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Person> persons = personMapper.findAllPerson();
        PageInfo<Person> PageInfo = new PageInfo<Person>(persons);
        return PageInfo;
    }
}
