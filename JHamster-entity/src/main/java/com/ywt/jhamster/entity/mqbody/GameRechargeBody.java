package com.ywt.jhamster.entity.mqbody;

import java.io.Serializable;
import java.math.BigDecimal;

public class GameRechargeBody implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer charId;  //角色id
	private String charName;  //角色名称
	private BigDecimal rechargeAmount; //充值金额
	private BigDecimal rechargeCash;  //到账点卷
	private Integer gameServer; //服务器
	public Integer getCharId() {
		return charId;
	}
	public void setCharId(Integer charId) {
		this.charId = charId;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public BigDecimal getRechargeCash() {
		return rechargeCash;
	}
	public void setRechargeCash(BigDecimal rechargeCash) {
		this.rechargeCash = rechargeCash;
	}
	public Integer getGameServer() {
		return gameServer;
	}
	public void setGameServer(Integer gameServer) {
		this.gameServer = gameServer;
	}
	
	

}
