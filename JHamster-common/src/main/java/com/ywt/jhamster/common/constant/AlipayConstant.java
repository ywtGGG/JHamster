package com.ywt.jhamster.common.constant;

public class AlipayConstant {
	
	/**
	 * 交易创建，等待买家付款
	 */
	public static String STATUS_WAIT_BUYER_PAY;
	/**
	 * 未付款交易超时关闭，或支付完成后全额退款
	 */
	public static String STATUS_TRADE_CLOSED;
	/**
	 * 交易支付成功
	 */
	public static String STATUS_TRADE_SUCCESS;
	/**
	 * 交易结束，不可退款
	 */
	public static String STATUS_TRADE_FINISHED;


}
