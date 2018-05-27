package com.ywt.jhamster.common.enums.business;


/**
 * 商品大类枚举：虚拟／真实商品
 * @author yuwentao
 *
 */
public enum GoodsTypeEnum {
	
	VIRTUAL(0,"虚拟商品"),
	REAL(1,"真实商品")
	;
	
	private Integer code;
	private String desc;
	GoodsTypeEnum(Integer code,String desc){
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
