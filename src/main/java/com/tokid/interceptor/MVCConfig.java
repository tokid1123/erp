package com.tokid.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public SwitchDataSourceInterceptor switchDataSourceInterceptor() {
        return new SwitchDataSourceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(switchDataSourceInterceptor()).excludePathPatterns("/static/*")
                .excludePathPatterns("/login").excludePathPatterns("/logout")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }

}
