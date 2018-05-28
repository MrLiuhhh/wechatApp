package com.example.demo.dao;

import com.example.demo.entity.AreaEntity;

import java.util.List;

/**
 * Created by liumolong on 18/5/29.
 */
public interface AreaDao {
    List<AreaEntity> findAll();
    AreaEntity findOne(int areaId);
    int addArea(AreaEntity areaEntity);
    int updateArea(AreaEntity areaEntity);
    int deleteArea(int areaId);

}
