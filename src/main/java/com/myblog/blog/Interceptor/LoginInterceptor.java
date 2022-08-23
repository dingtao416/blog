package com.myblog.blog.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        System.out.println("进入");
        Object o=request.getSession().getAttribute("user");
        if(o==null)
        {
            response.sendRedirect("/admin/login.html");
            return false;
        }
        return true;
    }
}
