package com.ywt.jhamster.payment.factory;

import com.ywt.jhamster.common.enums.business.ThirdPartyPaymentEnum;
import com.ywt.jhamster.common.utils.SpringContextHolder;

/**
 * 第三方支付工厂类
 * @author yuwentao
 * @date 2017-10-30
 */
public class ThirdPartyPaymentFactory {
	
	
	public static <T> T getThirdPartyPaymentByCode(Integer code) {
		switch (ThirdPartyPaymentEnum.getEnumByCode(code)) {
		case ZFB:
			return SpringContextHolder.getBean("aliPayService");
		case ADMIN:
			return SpringContextHolder.getBean("adminPayService");	
		default:
			break;
		}
		return null;
	}
}
