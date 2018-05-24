package com.example.demo.config.dao;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by liumolong on 18/5/24.
 */
@Configuration
public class SessionConfiguration {
//    实体类所在路径
    @Value("entity_package")
    private String entityPackage;

    @Autowired
    private DataSource datasource;

//    mybatis的mapper路径
    @Value("mybatis_path")
    private String mapperPath;

//    mybatis的配置文件
    @Value("mybatis_config")
    private java.lang.String mybatisPathConfig;

    /*
        *使用SqlSessionFactoryBean创建SqlSessionFactory ，
        *进而来创建 SqlSession。一旦你获得一个 session 之后,
        *你可以使用它来执行映射语句,提交或回滚连接,最后,当不再
        *需要它的时候, 你可以关闭 session。
         */
    @Bean(name = "sqlSessionBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
//        ClassPathResource为需要加载的资源文件的路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisPathConfig));
//        PathMatchingResourcePatternResolver用于搜索资源
        PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
        String searchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(searchPath));
        sqlSessionFactoryBean.setDataSource(datasource);
//        设置实体类的扫描路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        return sqlSessionFactoryBean;
    }
}
