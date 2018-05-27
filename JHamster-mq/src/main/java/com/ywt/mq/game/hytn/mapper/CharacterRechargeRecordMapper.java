/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * CharacterRechargeRecordMapper.java
 * 
 */
package com.ywt.mq.game.hytn.mapper;

import com.ywt.mq.entity.CharacterRechargeRecord;

/**
 * <p>
 * 表 : character_recharge_record的 Mapper 类
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
public interface CharacterRechargeRecordMapper {
    int deleteByPrimaryKey(Integer characterId);

    int insert(CharacterRechargeRecord record);

    int insertSelective(CharacterRechargeRecord record);

    CharacterRechargeRecord selectByPrimaryKey(Integer characterId);

    int updateByPrimaryKeySelective(CharacterRechargeRecord record);

    int updateByPrimaryKey(CharacterRechargeRecord record);
}