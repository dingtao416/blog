package com.myblog.blog.controller.admin;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class adminUserController {
    @Autowired
    private UserService userService;
    //发送请求到登录页面
    @GetMapping("/login")
    public String loginPage()
    {
        return "admin/login";
    }
    //用户登录表单验证
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session,
                        RedirectAttributes redirectAttributes)
    {
        User user= userService.checkUser(username,password);
        if(user!=null && "admin".equals(user.getUsername()))
        {
            session.setAttribute("user",user);
            return "admin/adminIndex";
        }
        else {
            redirectAttributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin/login";
        }
    }
    //注销用户
    @PostMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "redirect:admin/login";
    }
}
