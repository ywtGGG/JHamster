package com.ywt.jhamster.payment.business;

import com.ywt.jhamster.entity.model.business.Orders;

/**
 * 订单service
 * @author yuwentao
 *
 */
public interface OrderService {
	
	/**
	 * 插入订单
	 * @param order
	 */
	void createOrder(Orders order);
	
	Orders queryOrderByOrderNo(String orderNo);
	
	void updateOrder(Orders order);
}
