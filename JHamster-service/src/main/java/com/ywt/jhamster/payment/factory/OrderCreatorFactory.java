package com.ywt.jhamster.payment.factory;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ywt.jhamster.common.enums.business.GoodsTypeEnum;
import com.ywt.jhamster.order.creator.BaseCreator;
import com.ywt.jhamster.order.creator.RealGoodsCreator;
import com.ywt.jhamster.order.creator.VirtualGoodsCreator;

@Component
public class OrderCreatorFactory {
	
	@Autowired
	private VirtualGoodsCreator virtualGoodsCreator;
	@Autowired
	private RealGoodsCreator realGoodsCreator;
	
	private static Map<Integer, BaseCreator> creators = new HashMap<>();
	
	@PostConstruct
	public void init(){
		creators.put(GoodsTypeEnum.VIRTUAL.getCode(), virtualGoodsCreator);
		creators.put(GoodsTypeEnum.REAL.getCode(), realGoodsCreator);
	}
	
	/**
	 * 通过商品类型获取对应的订单创建器
	 * @param code
	 * @return
	 */
	public static BaseCreator getCreatorByCode(Integer code){
		return creators.get(code);
	}
}
