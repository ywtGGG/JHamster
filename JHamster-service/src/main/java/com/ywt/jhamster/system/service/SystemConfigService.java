package com.ywt.jhamster.system.service;

import java.util.List;

import com.ywt.jhamster.entity.model.system.SystemConfig;

/**
 * 系统配置
 * @author yuwentao
 *
 */
public interface SystemConfigService {
	
	/**
	 * 获取所有系统配置
	 * @return
	 */
	public List<SystemConfig> queryAllConfigs();

}
