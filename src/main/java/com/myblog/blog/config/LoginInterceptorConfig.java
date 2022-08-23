package com.myblog.blog.config;

import com.myblog.blog.Interceptor.LoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
//处理拦截器对象
@Component
public class LoginInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor=new LoginInterceptor();
        List<String> list=new ArrayList<>();
        list.add("/css/**");
        list.add("/images/**");
        list.add("/js/**");
        list.add("/admin/login");
        list.add("/login");
        list.add("/index.html");
        list.add("/user/login");
        list.add("/user/register");
        list.add("/login.html");
        list.add("/register.html");
        list.add("/bootstrap3/**");
        list.add("/");
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**").
                excludePathPatterns(list);
    }
}
