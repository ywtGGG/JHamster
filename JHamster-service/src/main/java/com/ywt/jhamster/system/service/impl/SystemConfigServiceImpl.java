package com.ywt.jhamster.system.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywt.jhamster.dal.system.SystemConfigMapperExt;
import com.ywt.jhamster.entity.model.system.SystemConfig;
import com.ywt.jhamster.system.service.SystemConfigService;


/**
 * 
 * @author yuwentao
 *
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
	
	@Autowired
	private SystemConfigMapperExt systemConfigMapperExt;
	
	@Override
	public List<SystemConfig> queryAllConfigs() {
		return systemConfigMapperExt.queryAllConfigs();
	}

}
