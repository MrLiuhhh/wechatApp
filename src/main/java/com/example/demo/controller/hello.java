package com.example.demo.controller;

import com.example.demo.entity.AreaEntity;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liumolong on 18/5/24.
 */
@RestController
public class Hello {
    @Autowired
    AreaRepository areaRepository;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        List<AreaEntity> list=areaRepository.findAll();
//        for (AreaEntity areaEntity:list){
//            areaEntity=list.get(0);
//        }
        return list.get(0).getAreaName();
    }
}
