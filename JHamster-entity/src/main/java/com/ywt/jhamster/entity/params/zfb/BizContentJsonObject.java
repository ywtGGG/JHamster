package com.ywt.jhamster.entity.params.zfb;

import java.math.BigDecimal;

/**
 * 支付宝BizContent参数
 * see https://docs.open.alipay.com/270/alipay.trade.page.pay
 * @author yuwentao
 *
 */
public class BizContentJsonObject {
	
	/**
	 * 商户订单号
	 */
	private String out_trade_no;
	/**
	 * 销售产品码，与支付宝签约的产品码名称。 注：目前仅支持FAST_INSTANT_TRADE_PAY
	 */
	private String product_code = "FAST_INSTANT_TRADE_PAY";
	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 */
	private BigDecimal total_amount;
	/**
	 * 订单标题
	 */
	private String subject;
	
	//////以上为必传参数
	/**
	 * 订单描述
	 */
	private String body;
	/**
	 * 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。
	 * 支付宝只会在异步通知时将该参数原样返回。
	 * 本参数必须进行UrlEncode之后才可以发送给支付宝
	 */
	private String passback_params;
	/**
	 * 业务扩展参数
	 */
	private String extend_params;
	
	/**
	 * 订单包含的商品列表信息，
	 * Json格式： {"show_url":"https://或http://打头的商品的展示地址"} ，
	 * 在支付时，可点击商品名称跳转到该地址
	 */
	private String goods_detail;
	/**
	 * 商品主类型：0—虚拟类商品，1—实物类商品（默认）
	 * 注：虚拟类商品不支持使用花呗渠道
	 */
	private String goods_type;
	/**
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。
	 * 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 
	 * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	 * 该参数在请求到支付宝时开始计时。
	 * 例如：90m
	 */
	private String timeout_express;
	/**
	 * 可用渠道，用户只能在指定渠道范围内支付
	 * 当有多个渠道时用“,”分隔
	 * 注：与disable_pay_channels互斥
	 */
	private String enable_pay_channels;
	/**
	 * 禁用渠道，用户不可用指定渠道支付
	 * 当有多个渠道时用“,”分隔
	 * 注：与enable_pay_channels互斥禁用渠道，用户不可用指定渠道支付
	 * 当有多个渠道时用“,”分隔
	 * 注：与enable_pay_channels互斥
	 */
	private String disable_pay_channels;
	/**
	 * 获取用户授权信息，可实现如免登功能。
	 * 获取方法请查阅：https://docs.open.alipay.com/289/105656
	 */
	private String auth_token;
	/**
	 * PC扫码支付的方式，支持前置模式和跳转模式。
	 * 前置模式是将二维码前置到商户的订单确认页的模式。需要商户在自己的页面中以iframe方式请求支付宝页面。
	 * 具体分为以下几种：
	 * 0：订单码-简约前置模式，对应iframe宽度不能小于600px，高度不能小于300px；
	 * 1：订单码-前置模式，对应iframe宽度不能小于300px，高度不能小于600px；
	 * 3：订单码-迷你前置模式，对应iframe宽度不能小于75px，高度不能小于75px；
	 * 4：订单码-可定义宽度的嵌入式二维码，商户可根据需要设定二维码的大小。
	 * 跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。
	 * 2：订单码-跳转模式
	 */
	private String qr_pay_mode;
	/**
	 * 商户自定义二维码宽度
	 * 注：qr_pay_mode=4时该参数生效
	 */
	private String qrcode_width;
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPassback_params() {
		return passback_params;
	}
	public void setPassback_params(String passback_params) {
		this.passback_params = passback_params;
	}
	public String getExtend_params() {
		return extend_params;
	}
	public void setExtend_params(String extend_params) {
		this.extend_params = extend_params;
	}
	public String getGoods_detail() {
		return goods_detail;
	}
	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}
	public String getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	public String getTimeout_express() {
		return timeout_express;
	}
	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}
	public String getEnable_pay_channels() {
		return enable_pay_channels;
	}
	public void setEnable_pay_channels(String enable_pay_channels) {
		this.enable_pay_channels = enable_pay_channels;
	}
	public String getDisable_pay_channels() {
		return disable_pay_channels;
	}
	public void setDisable_pay_channels(String disable_pay_channels) {
		this.disable_pay_channels = disable_pay_channels;
	}
	public String getAuth_token() {
		return auth_token;
	}
	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}
	public String getQr_pay_mode() {
		return qr_pay_mode;
	}
	public void setQr_pay_mode(String qr_pay_mode) {
		this.qr_pay_mode = qr_pay_mode;
	}
	public String getQrcode_width() {
		return qrcode_width;
	}
	public void setQrcode_width(String qrcode_width) {
		this.qrcode_width = qrcode_width;
	}
	

}
