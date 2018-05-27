package com.ywt.jhamster.thirdparty.business.service;

import com.ywt.jhamster.entity.params.CreateOrderVO;

public abstract interface BasePayService {
	
	
	/**
	 * 支付
	 * @param orderVo
	 * @return
	 */
	String pay(CreateOrderVO orderVo);

}
