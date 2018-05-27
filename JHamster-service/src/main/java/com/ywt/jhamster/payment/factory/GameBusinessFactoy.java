package com.ywt.jhamster.payment.factory;

import com.ywt.jhamster.common.enums.business.GameServerEnum;
import com.ywt.jhamster.common.utils.SpringContextHolder;

public class GameBusinessFactoy {

	public static <T> T getGameServiceByServer(Integer code) {
		switch (GameServerEnum.getEnumByCode(code)) {
		case HYTN:
			return SpringContextHolder.getBean("mxdService");
		default:
			break;
		}
		return null;
	}
}
