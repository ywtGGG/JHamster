package com.ywt.jhamster.thirdparty.business.service;

import java.io.IOException;
import java.util.Map;

import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * 支付宝接口封装
 * @author yuwentao
 * @date 2017-10-25
 */
public interface AliPayService extends BasePayService{
	
	/**
	 * 创建订单
	 */
	void createOrder();
	
	/**
	 * 生成付款二维码
	 */
	void createQRcode();
	
	/**
	 * 电脑网站支付
	 */
	String pagePay(AlipayTradePagePayRequest pagePayRequest) throws IOException;
	
	/**
	 * 查询订单
	 */
	void queryOrder();
	
	
	/**
	 * 支付宝验签
	 * @param params
	 */
	boolean doVerifySign(Map<String, String> params);
}
