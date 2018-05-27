package com.ywt.jhamster.web.configs;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DbConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource dataSource(){
		return new DruidDataSource();
	}
	
	@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        DruidDataSource dataSource = dataSource();
//        dataSource.setPassword(decryptDBPwd(dataSource.getPassword()));
        sqlSessionFactoryBean.setDataSource(dataSource);
//        "classpath:com/ywt/jhamster/dal**/*.xml"
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/ywt/jhamster/dal/**/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:META-INF/mybatis/configuration.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ywt.JHamster.entity.model");
        return sqlSessionFactoryBean;
    }
	
	@Bean
    public DataSourceTransactionManager transactionManager() {
        DruidDataSource dataSource = dataSource();
        return new DataSourceTransactionManager(dataSource);
    }
	
	/**
     * 数据库密码解密
     *
     * @param pwd
     * @return
     */
//    private String decryptDBPwd(String pwd) throws Exception {
//       WdDBPasswordFactory wdDBPasswordFactory = new WdDBPasswordFactory();
//       wdDBPasswordFactory.setPassword(pwd);
//       String password = wdDBPasswordFactory.getObject();
//       return password;
//    }



}
