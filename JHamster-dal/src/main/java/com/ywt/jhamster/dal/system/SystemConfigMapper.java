/**
 * 
 * SystemConfigMapper.java
 * 
 */
package com.ywt.jhamster.dal.system;

import com.ywt.jhamster.entity.model.system.SystemConfig;

/**
 * <p>
 * 表 : system_config的 Mapper 类
 * 
 * @author 	system
 * @date 	2017年10月28日
 */
public interface SystemConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfig record);

    int insertSelective(SystemConfig record);

    SystemConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConfig record);

    int updateByPrimaryKey(SystemConfig record);
}