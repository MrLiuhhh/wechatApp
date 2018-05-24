package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by liumolong on 18/5/24.
 */
@Configuration
//mapper扫描路径
@MapperScan("com.example.demo.config.dao")
public class dataSourceConfiguration {
    @Value("jdbc.driver")
    private String jdbcDriver;
    @Value("jdbc.url")
    private String jdbcUrl;
    @Value("jdbc.username")
    private String jdbcUser;
    @Value("jdbc.password")
    private String jdbcPassword;

    //    ComboPooledDataSource存储数据源接口池,和c3p0一起使用
    @Bean(name = "dataSource")
    private ComboPooledDataSource createDataSource(){
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
//        设置驱动
        try {
            dataSource.setDriverClass(jdbcDriver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
//        设置数据库url
        dataSource.setJdbcUrl(jdbcUrl);
//        设置数据哭用户名和密码
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
//        连接池关闭时是否自动提交
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
