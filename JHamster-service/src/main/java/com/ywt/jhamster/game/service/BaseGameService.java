package com.ywt.jhamster.game.service;

import com.ywt.jhamster.entity.params.game.GameRechargeVO;

public abstract interface BaseGameService {
	
	/**
	 * 处理充值成功的逻辑
	 * @param rechargeVO
	 */
	void doRecharge(GameRechargeVO rechargeVO);
}
