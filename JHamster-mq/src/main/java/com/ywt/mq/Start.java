package com.ywt.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//自动注入
@ComponentScan(basePackages ={"com.ywt.rocketmq"})
//mybatis路劲自动扫面
@MapperScan("com.ywt.rocketmq.dal")
@ServletComponentScan(value = "com.ywt.rocketmq")
//手动引入xml文件
@ImportResource({"classpath:component/rocketmq-config.xml"})
public class Start extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Start.class);
    }

	
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

}
