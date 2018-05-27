/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * CharacterRechargeRecordMapperExt.java
 * 
 */
package com.ywt.mq.game.hytn.mapper;

import javax.annotation.Resource;

/**
 * <p>
 * CharacterRechargeRecordMapper的扩展 Mapper 接口
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
@Resource
public interface CharacterRechargeRecordMapperExt extends CharacterRechargeRecordMapper {
	
	void addCharacterRechargeMoney(Integer money);
}