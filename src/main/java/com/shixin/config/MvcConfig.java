package com.shixin.config;

import jakarta.servlet.http.PushBuilder;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 是新
 * @create 2023-11-27 10:35
 * @Description :
 */
@Configuration
@ComponentScan("com.shixin.Controller")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    //开启静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//开启默认的servlet处理
    }
}
