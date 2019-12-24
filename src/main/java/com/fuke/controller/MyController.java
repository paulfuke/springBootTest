package com.fuke.controller;

import com.fuke.domain.JsonResult;
import com.fuke.domain.MyException;
import com.fuke.domain.TestConfig;
import com.fuke.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {


    Map<Object,Object> map = new HashMap<>();
    @GetMapping("/{id}/{name}")
    public Map save(@PathVariable(value = "id")Integer id,@PathVariable(value = "name")String name){
        map.clear();
        map.put("id",id);
        map.put("username",name);
        return map;
    }

    @PostMapping("/del_user/{del_id}")
    public Map del(@PathVariable("del_id")Integer delId){
        map.clear();
        map.put("delId",delId);
        return map;
    }

    @GetMapping("/testJson")
    public User get(){
        User user = new User();
        user.setPassword(79846532);
        user.setUsername("张三");
        user.setBirthday(new Date());
        return user;
    }
    @Autowired
    private TestConfig testConfig;
    @GetMapping("/myTest")
    public TestConfig test(){

        return testConfig;
    }

    @RequestMapping("/exceptionTest")
    public void exceptionTest(){
        throw new MyException(300,"出错");
    }

    @GetMapping("/bootTest")
    public JsonResult bootTest(){
        return new JsonResult(true,"测试成功");
    }
}
