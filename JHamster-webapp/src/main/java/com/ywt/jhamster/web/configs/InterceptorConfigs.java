package com.ywt.jhamster.web.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * 拦截器配置
 * @author yuwentao
 *
 */
@Configuration
public class InterceptorConfigs extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new BussinessExceptionInterceptor()).addPathPatterns("/**");
	}
}
