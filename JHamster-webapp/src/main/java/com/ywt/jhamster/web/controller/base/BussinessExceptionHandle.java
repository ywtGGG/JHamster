package com.ywt.jhamster.web.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywt.jhamster.common.constant.Result;
import com.ywt.jhamster.common.enums.web.ResultCode;
import com.ywt.jhamster.common.exception.BussinessException;


/**
 * 统一异常处理
 * @author yuwentao
 *
 */
@ControllerAdvice
public class BussinessExceptionHandle {
	
	private final static Logger logger = LoggerFactory.getLogger(BussinessExceptionHandle.class);
	
	@ExceptionHandler(value = {Exception.class}) 
	@ResponseBody 
	public Result<String> exceptionHandle(final Exception e){
		if (e instanceof BussinessException) {  //自定义异常
			BussinessException e2 = (BussinessException)e;
			return Result.faild(e2.getCode(),e2.getMessage());
		}
		//系统异常
		logger.error("Exception:", e);
		return Result.faild(ResultCode.SYS_ERROR);
	}
}
