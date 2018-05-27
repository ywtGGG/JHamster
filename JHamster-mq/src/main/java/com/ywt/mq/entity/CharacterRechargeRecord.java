/**
 * 
 * Copyright From 2015, 微贷（杭州）金融信息服务有限公司. All rights reserved.
 * 
 * CharacterRechargeRecord.java
 * 
 */
package com.ywt.mq.entity;

/**
 * <p>
 * 表 : character_recharge_record的 Model 类
 * 
 * @author 	system
 * @date 	2017年11月13日
 */
public class CharacterRechargeRecord {
    /** 字段:character_id，角色id */
    private Integer characterId;

    /** 字段:character_name，角色姓名 */
    private String characterName;

    /** 字段:recharge_money，充值金额 */
    private Integer rechargeMoney;

    /** 字段:gain_dj，已领取的点卷 */
    private Integer gainDj;

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName == null ? null : characterName.trim();
    }

    public Integer getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Integer rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Integer getGainDj() {
        return gainDj;
    }

    public void setGainDj(Integer gainDj) {
        this.gainDj = gainDj;
    }
}