package com.gx.springboot.config;

import com.gx.springboot.component.MyLocaleResolver;
import com.gx.springboot.intercepter.LoginIntecepter;
import com.gx.springboot.component.MyLocaleResolver;
import com.gx.springboot.intercepter.LoginIntecepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @createDate 2020/6/2 15:44
 */
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntecepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
    }

    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }
}
