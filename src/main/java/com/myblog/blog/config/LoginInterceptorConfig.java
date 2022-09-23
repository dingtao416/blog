package com.myblog.blog.config;

import com.myblog.blog.Interceptor.LoginInterceptor;
import com.myblog.blog.Interceptor.UserLoginInterceptor;
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
        list.add("/static/css/**");
        list.add("/static/images/**");
        list.add("/static/lib/**");
        list.add("/admin/login");
        list.add("/user/login");
        list.add("/user/register");
        list.add("/login.html");
        list.add("/register.html");
        list.add("/bootstrap3/**");
        list.add("/admin/logout");
        list.add("/user/{userId}");
        list.add("/user/UserSearch");
        list.add("/user/search");
        list.add("/user/follow/{followId}");
        HandlerInterceptor userLoginInterceptor =new UserLoginInterceptor();
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/user/**").excludePathPatterns(list);
        registry.addInterceptor(interceptor)
                .addPathPatterns("/admin/**").
                excludePathPatterns(list);
    }
}
