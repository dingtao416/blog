package com.myblog.blog.controller;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import com.myblog.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends baseController{
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public JsonResult<User> reg(User user)
    {
        System.out.println(user);
        userService.saveUser(user);
        return new JsonResult<>(OK,user);
    }
    @GetMapping("/register")
    public String re()
    {
        return "register";
    }
}
