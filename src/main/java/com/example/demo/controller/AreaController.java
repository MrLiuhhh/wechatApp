package com.example.demo.controller;

import com.example.demo.entity.AreaEntity;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumolong on 18/5/29.
 */
@RestController
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public void addArea(AreaEntity areaEntity){
        areaRepository.save(areaEntity);
    }

    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    public List<AreaEntity> listArea(){
        List<AreaEntity> list=new ArrayList<>();
        list=areaRepository.findAll();
        return list;
    }

    @RequestMapping(value = "/updateArea/{id}",method = RequestMethod.PUT)
    public void updateArea(String areaName,int areaId,int priority){
        AreaEntity areaEntity=new AreaEntity();

    }
}
