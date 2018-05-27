package com.ywt.jhamster.common.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * http工具类
 * @author yuwentao
 *
 */
public class HttpUtils {
	
	
	/**
	 * 获取HttpServletRequest
	 * spring框架下可用
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 获取HttpServletResponse
	 * spring框架下可用
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}
	
	/**
	 * 获取ServletContext
	 * spring框架下可用
	 * @return
	 */
	public static ServletContext getContext(){
		ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		return context;
	}
}
