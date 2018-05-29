package com.example.demo.repository;

import com.example.demo.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by liumolong on 18/5/26.
 */

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity,Integer>{
}
