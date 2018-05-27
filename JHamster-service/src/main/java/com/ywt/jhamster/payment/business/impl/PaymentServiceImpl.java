package com.ywt.jhamster.payment.business.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ywt.jhamster.common.constant.CommonConstant;
import com.ywt.jhamster.common.constant.Result;
import com.ywt.jhamster.common.enums.business.GameServerEnum;
import com.ywt.jhamster.common.enums.business.GoodsTypeEnum;
import com.ywt.jhamster.common.enums.business.OrderStatusEnum;
import com.ywt.jhamster.common.enums.business.ThirdPartyPaymentEnum;
import com.ywt.jhamster.common.exception.BussinessException;
import com.ywt.jhamster.common.utils.DateUtils;
import com.ywt.jhamster.common.utils.MD5Utils;
import com.ywt.jhamster.entity.params.CreateOrderVO;
import com.ywt.jhamster.entity.params.GameRechargeParams;
import com.ywt.jhamster.order.creator.BaseCreator;
import com.ywt.jhamster.payment.business.PaymentService;
import com.ywt.jhamster.payment.factory.OrderCreatorFactory;
import com.ywt.jhamster.payment.factory.ThirdPartyPaymentFactory;
import com.ywt.jhamster.thirdparty.business.service.BasePayService;

/**
 * 
 * @author yuwentao
 *
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {
	
	private final static Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Override
	public Result<String> gameRecharge(GameRechargeParams rechargeParams) {
		
		logger.info("gameRecharge params:{}",JSONObject.toJSONString(rechargeParams));
		
		if (!ThirdPartyPaymentEnum.ADMIN.getCode().equals(rechargeParams.getPayType())) {
			throw new BussinessException("暂时只支持管理员模式");
		}
		if (ThirdPartyPaymentEnum.ADMIN.getCode().equals(rechargeParams.getPayType())) {
			String pwd = MD5Utils.encode("y"+DateUtils.getDate()+"candy");
			if (!pwd.equals(rechargeParams.getAdminPw())) {
				throw new BussinessException("管理员密码错误");
			}
		}
		BaseCreator creator = OrderCreatorFactory.getCreatorByCode(GoodsTypeEnum.VIRTUAL.getCode());
		
		//订单标题
		String subject =GameServerEnum.getDescByCode(rechargeParams.getServer())+rechargeParams.getMoney()+"元";
		
		//构造订单
		CreateOrderVO createOrderVO = new CreateOrderVO();
		createOrderVO.setGoodsType(GoodsTypeEnum.VIRTUAL.getCode());
		createOrderVO.setCharacterId(rechargeParams.getCharacterId());
		createOrderVO.setCharacterName(rechargeParams.getCharacterName());
		createOrderVO.setWordServer(rechargeParams.getServer());
		createOrderVO.setPayType(rechargeParams.getPayType());
		createOrderVO.setTotalAmount(rechargeParams.getMoney());
		createOrderVO.setUid(CommonConstant.ADMIN_UID);
		createOrderVO.setCreateTime(DateUtils.getNow());
		createOrderVO.setStatus(ThirdPartyPaymentEnum.ADMIN.getCode().equals(rechargeParams.getPayType()) 
									? OrderStatusEnum.PAY_SUCCESS.getCode() : OrderStatusEnum.WAIT_PAY.getCode());
		createOrderVO.setSubject(subject);
		
		//创建订单
		String orderNo = creator.createOrder(createOrderVO);
		createOrderVO.setId(orderNo);
		BasePayService payService = ThirdPartyPaymentFactory.getThirdPartyPaymentByCode(rechargeParams.getPayType());
		if (null == payService) {
			throw new BussinessException("支付方式错误");
		}
		String from= payService.pay(createOrderVO);
		return new Result<>(from);
	}
	
}
