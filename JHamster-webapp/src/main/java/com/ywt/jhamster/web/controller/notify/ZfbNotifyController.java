package com.ywt.jhamster.web.controller.notify;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ywt.jhamster.common.constant.AlipayConstant;
import com.ywt.jhamster.common.enums.business.OrderStatusEnum;
import com.ywt.jhamster.entity.model.business.Orders;
import com.ywt.jhamster.entity.params.game.GameRechargeVO;
import com.ywt.jhamster.game.service.BaseGameService;
import com.ywt.jhamster.payment.business.OrderService;
import com.ywt.jhamster.payment.factory.GameBusinessFactoy;
import com.ywt.jhamster.thirdparty.business.service.AliPayService;
import com.ywt.jhamster.web.controller.base.BaseController;


/**
 * 支付宝异步回调
 * @author yuwentao
 *
 */
@Controller
@RequestMapping(value="/zfb/notify")
public class ZfbNotifyController extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(ZfbNotifyController.class);
	
	@Autowired
	private AliPayService aliPayService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/recharge")
	public void rechargeNotify(final HttpServletRequest request){
		Map<String, Object> requestMap = getRequestParams(request);
		logger.info("支付宝充值异步回调参数：{}", requestMap.get("toString"));
		@SuppressWarnings("unchecked")
		Map<String, String> paramsMap = (Map<String, String>) requestMap.get("params");
		boolean signVerified = aliPayService.doVerifySign(paramsMap);
		try {
			if (signVerified) {
				doGameRecharge(paramsMap);
				responseOutPush("success");
			}else {
				responseOutPush("failure");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	/**
	 * 处理充值逻辑
	 * @param params
	 */
	private void doGameRecharge(Map<String, String> params){
		Orders order = orderService.queryOrderByOrderNo(params.get("out_trade_no"));
		if (null != order) {
			String tradeStatus = params.get("trade_status");
			logger.info("订单号：{} ,支付宝page.pay返回状态：{}", order.getId(),tradeStatus);
			
			order.setReceiptAmount(new BigDecimal(params.get("receipt_amount")));
			order.setRefOrderId(params.get("trade_no"));
			order.setRemark("买家支付宝用户号："+params.get("buyer_id"));
			if (AlipayConstant.STATUS_TRADE_SUCCESS.equals(tradeStatus) || 
				(OrderStatusEnum.WAIT_PAY.getCode().equals(order.getStatus()) 
						&& AlipayConstant.STATUS_TRADE_FINISHED.equals(tradeStatus))) {
				BaseGameService gameService = GameBusinessFactoy.getGameServiceByServer(order.getWordServer());
				GameRechargeVO rechargeVO = new GameRechargeVO();
				rechargeVO.setCharId(order.getCharacterId());
				rechargeVO.setCharName(order.getCharacterName());
				rechargeVO.setGameServer(order.getWordServer());
				rechargeVO.setRechargeMoney(order.getTotalAmount());
				gameService.doRecharge(rechargeVO);
				order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
			}else {
				order.setStatus(OrderStatusEnum.PAY_FAILD.getCode());
			}
			orderService.updateOrder(order);
		}else {
			logger.error("未找到订单，订单号为：{}",params.get("out_trade_no"));
		}
	}
	
}
