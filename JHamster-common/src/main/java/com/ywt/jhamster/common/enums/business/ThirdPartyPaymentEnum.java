package com.ywt.jhamster.common.enums.business;


/**
 * 支付方式枚举
 * @author yuwentao
 *
 */
public enum ThirdPartyPaymentEnum {
	
	ADMIN(0,"管理员"),
	ZFB(1,"支付宝"),
	;
	private Integer code;
	private String desc;
	ThirdPartyPaymentEnum(Integer code,String desc){
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
	
	public static ThirdPartyPaymentEnum getEnumByCode(Integer code){
		for (ThirdPartyPaymentEnum e : ThirdPartyPaymentEnum.values()) {
			if (e.getCode().equals(code)) {
				return e;
			}
		}
		return null;
	}
	
}
