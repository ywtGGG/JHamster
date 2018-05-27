package com.ywt.jhamster.common.constant;

import java.io.Serializable;

import com.ywt.jhamster.common.enums.web.ResultCode;

/**
 * 系统通用返回前端结果
 * @author yuwentao
 * @param <T>
 * @date 2017-10-25
 */
public class Result<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回状态码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 返回数据
	 */
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public Result(T data){
		this.code = ResultCode.SUCCESS.getCode();
		this.message = ResultCode.SUCCESS.getMessage();
		this.data = data;
	}
	
	/**
	 * 空构造函数默认成功
	 */
	public Result(){
		this.code = ResultCode.SUCCESS.getCode();
		this.message = ResultCode.SUCCESS.getMessage();
	}
	
	public static <T> Result<T> faild(ResultCode resultCode){
		Result<T> result = new Result<T>();
		result.setCode(resultCode.getCode());
		result.setMessage(resultCode.getMessage());
		result.setData(null);
		return result;
	}
	
	public static <T> Result<T> faild(Integer code, String message){
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMessage(message);
		result.setData(null);
		return result;
	}

}
