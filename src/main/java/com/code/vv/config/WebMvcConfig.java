package com.code.vv.config;

import com.code.vv.web.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created on 2020/8/25.
 * com.code.vv.config
 *
 * @author Zjianru
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginAuthenticator;

    /**
     * 登录拦截器
     * @param registry registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
    }

    /**
     * 路径排除
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthenticator)
                .addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/loginPage")
                .excludePathPatterns("/anonymous")
                .excludePathPatterns("/getAnonymousList");
    }
}
