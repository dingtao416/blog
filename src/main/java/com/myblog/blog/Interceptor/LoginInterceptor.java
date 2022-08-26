package com.myblog.blog.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        Object o=request.getSession().getAttribute("user");
        if(o==null)
        {
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
