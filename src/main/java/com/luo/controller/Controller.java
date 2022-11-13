package com.luo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.luo.mapper.StudentMapper;
import com.luo.mapper.UserMapper;
import com.luo.pojo.Student;
import com.luo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*","null"})

public class Controller {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Gson gson;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public String getStudents(){
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }


    @PostMapping("/add")
    public  void addStudent(@RequestBody Student student){
        studentMapper.insert(student);
    }

    @PostMapping("delete")
    public void remove(@RequestBody Student student){
        studentMapper.deleteById(student);
    }

    @PostMapping("update")
    public void updateStudent(@RequestBody Student student){
        studentMapper.updateById(student);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.setEntity(user);
        User user_select = userMapper.selectOne(queryWrapper);
        if(user_select==null){
            return "0";
        }
        return "1";
    }

    @PostMapping("register")
    public void registerUser(@RequestBody User user){
        userMapper.insert(user);
    }
}
