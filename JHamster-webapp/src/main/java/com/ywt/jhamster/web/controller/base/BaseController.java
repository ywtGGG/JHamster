package com.ywt.jhamster.web.controller.base;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ywt.jhamster.common.utils.HttpUtils;


/**
 * 基础Controller
 * 
 * @author yuwentao
 *
 */
public class BaseController{

	private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 回调参数拼接共用方法
	 * 
	 * @return
	 */
	public Map<String, Object> getRequestParams(final HttpServletRequest request) {
		StringBuilder params = new StringBuilder();
		Map<String, Object> map = new HashMap<>();
		try {
			@SuppressWarnings("rawtypes")
			final Enumeration e = request.getParameterNames();
			Map<String, String> paramsMap= new HashMap<>();
			while (e.hasMoreElements()) {
				String parName = (String) e.nextElement();
				String value = request.getParameter(parName);
				params.append(parName).append("=").append(value).append("&");
				paramsMap.put(parName, value);
			}
			map.put("toString", params.toString());
			map.put("params", paramsMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return map;
	}
	
	/**
	 * 回调打印页面信息
	 * @param message
	 * @throws IOException 
	 */
	public void responseOutPush(String message) throws IOException{
		HttpServletResponse response = HttpUtils.getResponse();
		response.setContentType("text/html;charset=" + "UTF-8");
		response.getWriter().write(message);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
