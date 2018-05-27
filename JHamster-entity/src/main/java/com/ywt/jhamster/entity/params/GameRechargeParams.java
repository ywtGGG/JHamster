package com.ywt.jhamster.entity.params;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author yuwentao
 *
 */
public class GameRechargeParams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色id
	 */
	private Integer characterId;
	/**
	 * 角色名
	 */
	private String characterName;
	/**
	 * 服务器
	 */
	private Integer server;
	/**
	 * 支付方式
	 */
	private Integer payType;
	/**
	 * 充值金额
	 */
	private BigDecimal money;
	
	/**
	 * 管理员密码
	 */
	private String adminPw;
	
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
		this.characterName = characterName;
	}
	public Integer getServer() {
		return server;
	}
	public void setServer(Integer server) {
		this.server = server;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
}
