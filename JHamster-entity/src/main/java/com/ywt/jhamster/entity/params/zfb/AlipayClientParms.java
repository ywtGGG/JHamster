package com.ywt.jhamster.entity.params.zfb;

import java.io.Serializable;

/**
 * 支付宝创建AlipayClient参数
 * @author yuwentao
 *
 */
public class AlipayClientParms implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付宝网关
	 */
	private String url;
	/**
	 * 支付宝应用id
	 */
	private String appId;
	/**
	 * 开发者私钥
	 */
	private String appPrivateKey;
	/**
	 * 参数返回格式，只支持json
	 */
	private String format = "json";
	/**
	 * 编码集 支持GBK/UTF-8
	 */
	private String charset;
	/**
	 * 支付宝公钥
	 */
	private String alipayPublicKey;
	/**
	 * 签名算法类型 目前支持RSA2
	 */
	private String signType = "RSA2";
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppPrivateKey() {
		return appPrivateKey;
	}
	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}
	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	
	

}
