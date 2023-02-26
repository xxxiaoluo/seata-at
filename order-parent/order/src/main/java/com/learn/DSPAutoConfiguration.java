package com.learn;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DSPAutoConfiguration {
    //新建原始数据源对象
    @ConfigurationProperties(prefix = "spring.datasource") //将yml中的数据源配置注入到HikariDataSource对象中
    @Bean
    public DataSource dataSource(){
        return new HikariDataSource();
    }

    //新建数据源代理对象
    @Primary  //类型都是DataSource，@Primary把这个作为首选对象
    @Bean
    public DataSource dataSourcePoxy(DataSource ds){
        return new DataSourceProxy(ds);
    }
}