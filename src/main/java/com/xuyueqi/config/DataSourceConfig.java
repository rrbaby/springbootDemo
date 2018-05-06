package com.xuyueqi.config;

import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by xyq on 2018/5/5.
 */

@Configuration
@MapperScan("com.xuyueqi.model")
@Slf4j
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Autowired
    private PageInterceptor pageInterceptor;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws  Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
        return  sqlSessionFactoryBean.getObject();
    }

}
