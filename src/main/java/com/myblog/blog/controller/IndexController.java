package com.myblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //输入用户名 密码查询是否存在
    @GetMapping("/*/*")
    public  void index(String username,String password)
    {

    }
}
