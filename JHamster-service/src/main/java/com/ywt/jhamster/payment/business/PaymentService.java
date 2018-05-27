package com.ywt.jhamster.payment.business;

import com.ywt.jhamster.common.constant.Result;
import com.ywt.jhamster.entity.params.GameRechargeParams;

/**
 * 第三方支付service
 * @author yuwentao
 * @date 2017-10-30
 */
public interface PaymentService {
	
	/**
	 * 点卷充值
	 * @return
	 */
	Result<String> gameRecharge(GameRechargeParams rechargeParams);

}
