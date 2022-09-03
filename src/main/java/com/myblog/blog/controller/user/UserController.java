package com.myblog.blog.controller.user;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.controller.baseController;
import com.myblog.blog.entity.User;
import com.myblog.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends baseController {
    @Autowired
    private UserService userService;
//注册
    @Value("${user.avatar}")
    String avatar;

    @GetMapping("/register")
    public String register()
    {
        return "register";
    }
     @PostMapping("/register")
     public String reg(User user)
     {
         user.setAvatar(avatar);
        userService.saveUser(user);
        //注册成功进入登陆页面
        return "userLogin";
     }
     /*
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
    登陆*/
     @GetMapping("/login")
     public  String regpages()
     {
         return "userLogin";
     }
@PostMapping("/login")
public  String dd(String username, String password, HttpSession session,
                  RedirectAttributes redirectAttributes)
{
    System.out.println("进入");
    User user= userService.checkUser(username,password);
    if((user == null||username.equals("admin")))
    {
        System.out.println("进入2");
        System.out.println(username+password);
        redirectAttributes.addFlashAttribute("message","用户名和密码错误");
        return "redirect:/user/login";
        //失败重定向至原来页面
    }
    else {
        System.out.println("进入3");
        session.setAttribute("user",user);
        return "redirect:/index";
        //登陆成功进入下一页面 index
    }
}
    //修改
    @PostMapping("/update/{id}")
    /**
     * 修改user数据
     * @user
     * @id
     * @return
     */
    public  JsonResult<User> update(@RequestBody User user,@PathVariable Integer id)
    {
        user.setId(id);
        userService.updateUser(user);
        return new JsonResult<>(OK,"修改成功");
    }
}