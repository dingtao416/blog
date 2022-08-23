package com.myblog.blog.controller;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {
    private UserService userService;

    @GetMapping
    public String LoginPages() {
        //进入管理员登陆页面
        return "admin/login";
    }
//登陆用户
    @PostMapping("/login")
    public String Login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        //
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";

        } else {
            attributes.addFlashAttribute("message","用户名密码错误");
            return "redirect:/admin";
            //重定向

        }

    }
    //注销用户
    @GetMapping
    public String LogOut(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
