package com.ywt.jhamster.thirdparty.business.service.impl;

import org.springframework.stereotype.Service;

import com.ywt.jhamster.common.constant.CommonConstant;
import com.ywt.jhamster.entity.params.CreateOrderVO;
import com.ywt.jhamster.entity.params.game.GameRechargeVO;
import com.ywt.jhamster.game.service.BaseGameService;
import com.ywt.jhamster.payment.factory.GameBusinessFactoy;
import com.ywt.jhamster.thirdparty.business.service.AdminPayService;

/**
 * 
 * @author yuwentao
 *
 */
@Service("adminPayService")
public class AdminPayServiceImpl implements AdminPayService {

	@Override
	public String pay(CreateOrderVO orderVo) {
		BaseGameService gameService = GameBusinessFactoy.getGameServiceByServer(orderVo.getWordServer());
		GameRechargeVO rechargeVO = new GameRechargeVO();
		rechargeVO.setCharId(orderVo.getCharacterId());
		rechargeVO.setCharName(orderVo.getCharacterName());
		rechargeVO.setGameServer(orderVo.getWordServer());
		rechargeVO.setRechargeMoney(orderVo.getTotalAmount());
		gameService.doRecharge(rechargeVO);
		return CommonConstant.SUCCESS;
	}

}
