package com.myblog.blog.controller;

import com.myblog.blog.Service.ex.*;
import com.myblog.blog.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class baseController {
    public static final int OK=200;
    @ExceptionHandler(BaseException.class)
    public JsonResult<Void> handleException(Throwable e)
    {
        JsonResult<Void> result=new JsonResult<>();
        if(e instanceof UsernameDupException)
        {
            result.setState(4000);
            result.setMessage("用户名被占用");
        }
        else if(e instanceof UserNameNotFoundException)
        {
            result.setState(5001);
            result.setMessage("用户数据不存在异常");
        }
        else if(e instanceof PasswordNotMatchException)
        {
            result.setState(5000);
            result.setMessage("密码数据不匹配");
        }
        else if(e instanceof InsertException)
        {
            result.setState(5000);
            result.setMessage("注册出现未知异常");
        }
        return result;
    }
}
