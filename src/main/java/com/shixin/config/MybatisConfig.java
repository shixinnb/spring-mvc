package com.shixin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 是新
 * @create 2023-11-27 11:06
 * @Description :
 */
@Configuration
@MapperScan("com.shixin.mapper")
public class MybatisConfig {


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);


        org.apache.ibatis.session.Configuration configuration
                = new org.apache.ibatis.session.Configuration();


        configuration.setMapUnderscoreToCamelCase(true);//自动驼峰命名，数据库_命名变成驼峰命名

   /*     这个配置项用于设置 MyBatis 在自动映射（将数据库查询结果映射为 Java 对象）时的行为。
        AutoMappingBehavior.FULL 表示 MyBatis 将会自动映射所有的结果集字段到 Java 对象中。*/
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);//设置日志输出
        sqlSessionFactoryBean.setConfiguration(configuration);

        //设置类别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.shixin.pojo");

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.addPlugins(pageInterceptor);
        return sqlSessionFactoryBean;
    }

    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.shixin.mapper");
        return mapperScannerConfigurer;
    }
}
