package com.ywt.jhamster.order.creator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ywt.jhamster.common.utils.OrderUtils;
import com.ywt.jhamster.entity.model.business.Orders;
import com.ywt.jhamster.entity.params.CreateOrderVO;
import com.ywt.jhamster.payment.business.OrderService;

public abstract class BaseCreator implements OrderCreator<String,CreateOrderVO >{
	
	@Autowired
	private OrderService orderService;

	@Override
	public String createOrder(CreateOrderVO createOrderVO) {
		Orders order = new Orders();
		BeanUtils.copyProperties(createOrderVO, order);
		String orderNo = OrderUtils.getOrderNum(createOrderVO.getGoodsType(), createOrderVO.getWordServer(), createOrderVO.getPayType());
		order.setId(orderNo);
		orderService.createOrder(order);
		return orderNo;
	}
	
}
