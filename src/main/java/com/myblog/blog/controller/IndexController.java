package com.myblog.blog.controller;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.Service.impl.UserServiceimpl;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Usermapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private UserService userService;
    //输入用户名 密码查询是否存在
    @GetMapping("/dl")
    public  void index(String username,String password)
    {
       User user= userService.checkUser(username,password);
       if(user==null)
       {
           System.out.println("失败");
       }


    }
}
