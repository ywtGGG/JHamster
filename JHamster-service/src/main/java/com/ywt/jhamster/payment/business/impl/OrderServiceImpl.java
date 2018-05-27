package com.ywt.jhamster.payment.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywt.jhamster.common.enums.web.ResultCode;
import com.ywt.jhamster.common.exception.BussinessException;
import com.ywt.jhamster.dal.business.OrdersMapperExt;
import com.ywt.jhamster.entity.model.business.Orders;
import com.ywt.jhamster.payment.business.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrdersMapperExt ordersMapperExt;

	@Override
	public void createOrder(Orders order) {
		try {
			ordersMapperExt.insert(order);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}

	@Override
	public Orders queryOrderByOrderNo(String orderNo) {
		try {
			return ordersMapperExt.selectByPrimaryKey(orderNo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}

	@Override
	public void updateOrder(Orders order) {
		try {
			ordersMapperExt.updateByPrimaryKeySelective(order);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.DB_ERROR);
		}
	}
	

}
