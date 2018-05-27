package com.ywt.jhamster.common.function;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.ywt.jhamster.common.constant.CommonConstant;
import com.ywt.jhamster.entity.params.zfb.AlipayClientParms;
import com.ywt.jhamster.system.configs.SystemConfigMap;

/**
 * 公用的方法
 * @author yuwentao
 *
 */
public class CommonFunction {
	
	/**
	 * 初始化支付宝AlipayClient
	 * @param url   网关
	 * @param appId  应用id
	 * @param appPrivatekey  应用私钥
	 * @param format  参数返回格式，只支持json
	 * @param charset 编码集 支持GBK/UTF-8
	 * @param alipayPublicKey 支付宝公钥
	 * @param signType  签名算法类型 目前支持RSA2
	 * @return
	 */
	public static AlipayClient initAlipayClient(
					String url,
					String appId,
					String appPrivatekey,
					String format,
					String charset,
					String alipayPublicKey,
					String signType
			){
		AlipayClient alipayClient = new DefaultAlipayClient(url, appId, appPrivatekey, format, charset, alipayPublicKey, signType);
		return alipayClient;
	}
	
	
	/**
	 * 获取 AlipayClientParms
	 * @return
	 */
	public static AlipayClientParms getAlipayClientParms() {
		AlipayClientParms alipayClientParms = new AlipayClientParms();
		alipayClientParms.setCharset("UTF-8");
		
		if (CommonConstant.NO_STR.equals(SystemConfigMap.getConfig(CommonConstant.TEST_SWITCH).getValue())) {
			alipayClientParms.setUrl(SystemConfigMap.getConfig(CommonConstant.ZFB_URL_DEV).getValue());
			alipayClientParms.setAppId(SystemConfigMap.getConfig(CommonConstant.ZFB_APP_ID_DEV).getValue());
			alipayClientParms.setAlipayPublicKey(SystemConfigMap.getConfig(CommonConstant.ZFB_PUBLIC_KEY_DEV).getValue());
			alipayClientParms.setAppPrivateKey(SystemConfigMap.getConfig(CommonConstant.ZFB_APP_PRIVATE_KEY_DEV).getValue());
		}else {
			alipayClientParms.setUrl(SystemConfigMap.getConfig(CommonConstant.ZFB_URL).getValue());
			alipayClientParms.setAppId(SystemConfigMap.getConfig(CommonConstant.ZFB_APP_ID).getValue());
			alipayClientParms.setAlipayPublicKey(SystemConfigMap.getConfig(CommonConstant.ZFB_PUBLIC_KEY).getValue());
			alipayClientParms.setAppPrivateKey(SystemConfigMap.getConfig(CommonConstant.ZFB_APP_PRIVATE_KEY).getValue());
		}
		
		return alipayClientParms;
	}
}
