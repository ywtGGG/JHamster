package com.ywt.jhamster.common.enums.business;

/**
 * 订单状态
 * @author yuwentao
 *
 */
public enum OrderStatusEnum {
	/**
	 * 等待付款
	 */
	WAIT_PAY(0,"等待付款"),
	/**
	 * 付款成功
	 */
	PAY_SUCCESS(1,"付款成功"),
	/**
	 * 付款失败
	 */
	PAY_FAILD(2,"付款失败"),
	/**
	 * 订单异常
	 */
	ERROR(3,"订单异常"),
	;
	private Integer code;
	private String desc;
	
	
	private OrderStatusEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
