package com.xuyueqi.config;


import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * create by xuyueqi on 2018/5/5
 */
@Configuration
public class PageHelperConfig {

    @Value("${pagehelper.helper-dialect}")
    private String helperDialect;


    @Bean
    public PageInterceptor pageInterceptor(){
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect",helperDialect);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }


}
