package com.ywt.jhamster.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 解决跨域Filter
 * 
 * @author 	刘世茂 ( 492788802@qq.com )
 * @date 	2017年5月4日
 * @version 1.0.0
 */

@WebFilter(urlPatterns = "/*", filterName = "crossFilter")
public class CrossFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	/**
	 * <p>
	 * 解决跨域问题
	 * 
	 * @author 刘世茂 ( 492788802@qq.com )
	 * @date 2017年5月4日
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		servletResponse.setHeader("Access-Control-Allow-Origin", servletRequest.getHeader( "Origin" ) );
		//		servletResponse.setHeader("Access-Control-Allow-Origin", servletRequest.getHeader("Origin") == null ? "*" : servletRequest.getHeader("Origin"));
		servletResponse.setHeader("Access-Control-Allow-Methods", servletRequest.getHeader( "Access-Control-Allow-Method" ));
		servletResponse.setHeader("Access-Control-Allow-Headers", servletRequest.getHeader( "Access-Control-Request-Headers" ));
		
		servletResponse.setHeader("Access-Control-Max-Age", "86400" );
		servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
}
