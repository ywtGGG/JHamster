/**
 * 
 * SystemConfig.java
 * 
 */
package com.ywt.jhamster.entity.model.system;

import java.util.Date;

/**
 * <p>
 * 表 : system_config的 Model 类
 * 
 * @author 	system
 * @date 	2017年10月28日
 */
public class SystemConfig {
    /** 字段:id */
    private Integer id;

    /** 字段:key，配置名称 */
    private String key;

    /** 字段:value，配置值 */
    private String value;

    /** 字段:status，状态 0-关闭  1-开启 */
    private Integer status;

    /** 字段:create_time，创建时间 */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}