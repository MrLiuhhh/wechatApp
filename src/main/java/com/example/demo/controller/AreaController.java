package com.example.demo.controller;

import com.example.demo.entity.AreaEntity;
import com.example.demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumolong on 18/5/29.
 */
@RestController
@ResponseBody
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public void addArea(@RequestBody AreaEntity areaEntity){
        areaRepository.save(areaEntity);
    }

    @RequestMapping(value = "/listArea",method = RequestMethod.GET)
    public List<AreaEntity> listArea(){
        List<AreaEntity> list=new ArrayList<>();
        list=areaRepository.findAll();
        return list;
    }
    @RequestMapping(value = "/getArea",method = RequestMethod.GET)
    public AreaEntity getArea(@RequestParam int areaId){
        return areaRepository.findOne(areaId);
    }

    @RequestMapping(value = "/updateArea/{areaId}",method = RequestMethod.PUT)
    public void updateArea(@PathVariable int areaId,String areaName,int priority){
        AreaEntity areaEntity=areaRepository.findOne(areaId);
        areaEntity.setAreaName(areaName);
        areaEntity.setPriority(priority);

        areaRepository.save(areaEntity);
    }

    @RequestMapping(value = "/deleteArea/{areaId}",method = RequestMethod.PUT)
    public void deleteArea(@PathVariable int areaId){
        areaRepository.delete(areaId);
    }
}
