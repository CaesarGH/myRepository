package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.BeanUser;

import com.example.mapper.BeanUserMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController

public class ControllerBean {

    @Autowired

    BeanUserMapper beanUserMapper;

//    //查询
//
//    @GetMapping("/get/{id}")
//
//    public BeanUser getBeanUser(@PathVariable("id") Integer id){
//
//        return beanUserMapper.selectId(id);
//
//    }
    //查询

    @GetMapping("/getUsers")

    public List<BeanUser> getAllBeanUser(){

        return beanUserMapper.selectAll();

    }
    //插入

    @PostMapping("/insert")

    public BeanUser insertBeanUser(BeanUser beanUser){

        beanUserMapper.insertBean(beanUser);

        return beanUser;

    }
    //修改

    @PutMapping("/update")

    public BeanUser updateBeanUser(BeanUser beanUser){

        beanUserMapper.UpdateBean(beanUser);

        return beanUser;

    }
    //删除

    @DeleteMapping("/delete/{id}")

    public JSONObject deleteBeanUser(@PathVariable("id")Integer id){

         beanUserMapper.deleteId(id);
         String json = "{\"message\":\"删除成功！\"}";

         JSONObject json_message = JSONObject.parseObject(json); 

         return json_message;

    }
    
    @RequestMapping("/hello")
	public String helloSpringBoot() {
		return "Hello SpringBoot Project.";
	}

}