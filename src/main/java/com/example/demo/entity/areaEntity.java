package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by liumolong on 18/5/24.
 */
@Entity
@Table(name = "tb_area")
public class AreaEntity {
    @Id
    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_edit_time")
    private Date lastEditTime;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
