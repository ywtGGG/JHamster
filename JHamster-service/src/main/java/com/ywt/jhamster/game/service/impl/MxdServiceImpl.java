package com.ywt.jhamster.game.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywt.jhamster.common.function.MqSender;
import com.ywt.jhamster.entity.model.rule.Rule;
import com.ywt.jhamster.entity.params.game.GameRechargeVO;
import com.ywt.jhamster.game.service.MxdService;
import com.ywt.jhamster.game.service.RuleService;

@Service("mxdService")
public class MxdServiceImpl implements MxdService{
	
	@Autowired
	private RuleService ruleService;
	
	@Override
	public void doRecharge(GameRechargeVO rechargeVO) {
		List<Rule> rules = ruleService.queryRuleListBykey("hytn_recharge_award");
		rechargeVO.setRealDJ(rechargeVO.getRechargeMoney());
		for (Rule rule : rules) {
			//设置实际获取的点卷值(充值金额+奖励金额)
			if (rechargeVO.getRechargeMoney().intValue()>=rule.getTriggering()) {
				rechargeVO.setRealDJ(rechargeVO.getRechargeMoney().add(new BigDecimal(rule.getAward())));
				break;//奖励取最高
			}
		}
		MqSender.sendRechargeMessage(rechargeVO);
	}

}
