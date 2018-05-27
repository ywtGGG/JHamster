package com.ywt.jhamster.web.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ywt.jhamster.entity.model.system.SystemConfig;
import com.ywt.jhamster.system.configs.SystemConfigMap;
import com.ywt.jhamster.system.service.SystemConfigService;


/**
 * 初始化配置监听器
 * @author yuwentao
 *
 */
@Component
public class ConfigInitListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private SystemConfigService systemConfigService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<SystemConfig> configs = systemConfigService.queryAllConfigs();
		if (!configs.isEmpty()) {
			for (SystemConfig systemConfig : configs) {
				SystemConfigMap.properties.put(systemConfig.getKey(), systemConfig);
			}
		}
	}

}
