package com.ywt.jhamster.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//自动注入
@ComponentScan(basePackages ={"com.ywt.jhamster"})
//@ServletComponentScan(value = "cn.com.weidai.financial.web.filter")
//手动引入xml文件
//@ImportResource({"classpath:dubbo-config.xml","classpath:spring-bean.xml"})
public class Start extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Start.class);
    }

	
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

}
