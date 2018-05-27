package com.ywt.jhamster.system.configs;

import java.util.HashMap;
import java.util.Map;

import com.ywt.jhamster.entity.model.system.SystemConfig;

/**
 * 系统配置信息
 * @author yuwentao
 *
 */
public class SystemConfigMap {
	
	/**
	 * 系统配置信息
	 */
	public static Map<String, SystemConfig> properties = new HashMap<>();
	
	public static SystemConfig getConfig(String key){
		return properties.get(key);
	}
	
}
