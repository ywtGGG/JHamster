package com.ywt.jhamster.common.enums.web;

/**
 * 返回code码
 * @author yuwentao
 *
 */
public enum ResultCode {
	
	SUCCESS(0,"success"),
	DB_ERROR(1001,"数据库操作异常"),
	PARM_ERROR(1002,"参数异常"),
	SYS_ERROR(1111,"系统异常")
	;
	

	private Integer code;
	private String message;
	
	ResultCode(Integer code,String message){
		this.code = code;
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
