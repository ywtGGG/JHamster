package com.ywt.jhamster.thirdparty.business.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ywt.jhamster.common.constant.CommonConstant;
import com.ywt.jhamster.common.enums.business.GoodsTypeEnum;
import com.ywt.jhamster.common.enums.web.ResultCode;
import com.ywt.jhamster.common.exception.BussinessException;
import com.ywt.jhamster.common.function.CommonFunction;
import com.ywt.jhamster.entity.params.CreateOrderVO;
import com.ywt.jhamster.entity.params.zfb.AlipayClientParms;
import com.ywt.jhamster.entity.params.zfb.BizContentJsonObject;
import com.ywt.jhamster.system.configs.SystemConfigMap;
import com.ywt.jhamster.thirdparty.business.service.AliPayService;


/**
 * 支付宝接口封装
 * @author yuwentao
 * @date 2017-10-25
 */
@Service("aliPayService")
public class AliPayServiceImpl implements AliPayService {
	
	private final static Logger logger = LoggerFactory.getLogger(AliPayServiceImpl.class);
	
	@Override
	public void createOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createQRcode() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void queryOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String pagePay(AlipayTradePagePayRequest pagePayRequest) throws IOException {
		AlipayClientParms aliPayParms = CommonFunction.getAlipayClientParms();
		AlipayClient alipayClient = CommonFunction.initAlipayClient(aliPayParms.getUrl(), 
																	aliPayParms.getAppId(), 
																	aliPayParms.getAppPrivateKey(), 
																	aliPayParms.getFormat(), 
																	aliPayParms.getCharset(), 
																	aliPayParms.getAlipayPublicKey(), 
																	aliPayParms.getSignType());
	    String form="";
	    try {
	        form = alipayClient.pageExecute(pagePayRequest).getBody(); //调用SDK生成表单
	    } catch (AlipayApiException e) {
	    	System.out.println(e);
	        e.printStackTrace();
	    }
	    return form;
	}

	@Override
	public String pay(CreateOrderVO orderVo) {
		// 分装支付宝参数
		BizContentJsonObject bizObject = new BizContentJsonObject();
		bizObject.setOut_trade_no(orderVo.getId());
		bizObject.setTotal_amount(orderVo.getTotalAmount());
		bizObject.setSubject(orderVo.getSubject());
		bizObject.setTimeout_express("10m");
		bizObject.setGoods_type(GoodsTypeEnum.VIRTUAL.getCode().toString());
		AlipayTradePagePayRequest pagePayRequest = new AlipayTradePagePayRequest();
		pagePayRequest.setReturnUrl(SystemConfigMap.getConfig(CommonConstant.ZFB_NOTIFY_URL).getValue()+"/zfb/notify/recharge");
		pagePayRequest.setNotifyUrl(SystemConfigMap.getConfig(CommonConstant.ZFB_RETURN_URL).getValue());//在公共参数中设置回跳和通知地址
		pagePayRequest.setBizContent(JSONObject.toJSONString(bizObject));//填充业务参数
		String form="";
		try {
			form = pagePay(pagePayRequest);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new BussinessException(ResultCode.SYS_ERROR);
		}
		return form;
	}

	@Override
	public boolean doVerifySign(Map<String, String> params) {
		String alipayPublicKey = "";
		if (CommonConstant.NO_STR.equals(SystemConfigMap.getConfig(CommonConstant.TEST_SWITCH).getValue())) {
			alipayPublicKey = SystemConfigMap.getConfig(CommonConstant.ZFB_PUBLIC_KEY_DEV).getValue();
		}else {
			alipayPublicKey = SystemConfigMap.getConfig(CommonConstant.ZFB_PUBLIC_KEY).getValue();
		}
		try {
			return AlipaySignature.rsaCheckV1(params, alipayPublicKey, params.get("charset"),params.get("sign_type"));
		} catch (AlipayApiException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

}
