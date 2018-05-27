package com.ywt.jhamster.entity.params.game;

import java.math.BigDecimal;

public class GameRechargeVO {
	
	/**
	 * 服务器
	 */
	private Integer gameServer;
	
	/**
	 * 角色id
	 */
	private Integer charId;
	
	/**
	 * 角色姓名
	 */
	private String charName;
	
	/**
	 * 充值金额
	 */
	private BigDecimal rechargeMoney;
	
	/**
	 * 实际点卷
	 */
	private BigDecimal realDJ;

	public Integer getGameServer() {
		return gameServer;
	}

	public void setGameServer(Integer gameServer) {
		this.gameServer = gameServer;
	}

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

	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public BigDecimal getRealDJ() {
		return realDJ;
	}

	public void setRealDJ(BigDecimal realDJ) {
		this.realDJ = realDJ;
	}
	
}
