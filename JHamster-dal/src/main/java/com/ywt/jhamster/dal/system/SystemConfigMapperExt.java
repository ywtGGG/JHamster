/**
 * 
 * SystemConfigMapperExt.java
 * 
 */
package com.ywt.jhamster.dal.system;

import java.util.List;

import javax.annotation.Resource;

import com.ywt.jhamster.entity.model.system.SystemConfig;

/**
 * <p>
 * SystemConfigMapper的扩展 Mapper 接口
 * 
 * @author 	system
 * @date 	2017年10月28日
 */
@Resource
public interface SystemConfigMapperExt extends SystemConfigMapper {
	
	/**
	 * 查询所有系统配置
	 * @return
	 */
	public List<SystemConfig> queryAllConfigs();
}