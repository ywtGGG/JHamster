package com.ywt.jhamster.web.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywt.jhamster.common.constant.Result;
import com.ywt.jhamster.common.function.MqSender;
import com.ywt.jhamster.entity.params.GameRechargeParams;
import com.ywt.jhamster.payment.business.PaymentService;
import com.ywt.jhamster.web.controller.base.BaseController;

/**
 * Controller
 * @author yuwentao
 *
 */
@Controller
@RequestMapping(value="/payment")
public class PaymentController extends BaseController{
	
	@Autowired
	private PaymentService paymentService;
	
	
	//测试exception
	@RequestMapping("/hello")
	public void index(GameRechargeParams recharge) {
		MqSender sender = new MqSender();
		sender.test();
		
	}
	
	//测试bussniss异常
	@RequestMapping("/hello1")
	public void index1(GameRechargeParams recharge) {
		MqSender.test1();
		
	}
	
	//测试success
	@RequestMapping("/hello2")
	@ResponseBody
	public Result<String> index2() {
		return new Result<>(MqSender.test2());
	}
	
	
	/**
	 * 充值
	 * @param rechargeParams
	 */
	@RequestMapping(value="gameRecharge")
	@ResponseBody
	public Result<String> gameRecharge(GameRechargeParams rechargeParams){
		return paymentService.gameRecharge(rechargeParams);
	}
	
}
