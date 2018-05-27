package com.ywt.jhamster.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude =ErrorMvcAutoConfiguration.class)
@ComponentScan(basePackages ={"com.ywt.jhamster"}) //自动注入
@MapperScan("com.ywt.jhamster.dal") //mybatis路劲自动扫面
@ServletComponentScan(value = "com.ywt.jhamster.web")
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
