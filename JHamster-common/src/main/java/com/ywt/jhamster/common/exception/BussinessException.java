package com.ywt.jhamster.common.exception;

import com.ywt.jhamster.common.enums.web.ResultCode;

public class BussinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;

    private String message;
	
	/**
	 * 默认构造方法
	 */
	public BussinessException() {
		super();
	}
	public BussinessException(String message) {
		super(message);
		this.code = ResultCode.SYS_ERROR.getCode();
		this.message = message;
	}
	public BussinessException(Integer code,String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	public BussinessException(ResultCode resultCode) {
		super(resultCode.getMessage());
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}
	
	public BussinessException(Throwable e) {
		super(e);
	}
	
	public BussinessException(Integer code,String message,Throwable e) {
		super(message,e);
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
