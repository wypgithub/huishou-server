package com.huishou.interceptor;


import org.hibernate.validator.internal.engine.messageinterpolation.parser.TokenIterator;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * <p/>
 * <li>Description:拦截器注册</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/03  </li>
 * <li>@version: 1.0 </li>
 */
@Configuration
public class CustomWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());


        registration.addPathPatterns("/index/**","/eval/**","/my/**");

    }


}
