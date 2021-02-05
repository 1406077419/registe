package com.registe.brick.sysbrick.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterseptorMvcConfig implements WebMvcConfigurer {

    @Bean
    public AuthInterceptor getRequestInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/*/*");  // token 验证拦截器,注册spring 容器中的拦截器对象
    }
}
