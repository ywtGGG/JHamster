/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * Rule.java
 * 
 */
package com.ywt.jhamster.entity.model.rule;

import java.util.Date;

/**
 * <p>
 * 表 : rule的 Model 类
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
public class Rule {
    /** 字段:id */
    private Integer id;

    /** 字段:name，规则名称 */
    private String name;

    /** 字段:key，规则key */
    private String key;

    /** 字段:triggering，触发条件 */
    private Integer triggering;

    /** 字段:award，奖励值 */
    private Integer award;

    /** 字段:create_time，创建时间 */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public Integer getTriggering() {
        return triggering;
    }

    public void setTriggering(Integer triggering) {
        this.triggering = triggering;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}