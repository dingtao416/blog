package com.myblog.blog.controller.user;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.controller.baseController;
import com.myblog.blog.entity.User;
import com.myblog.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
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

@GetMapping("/register")
public  String regpages()
{
    return "register";
}

    @PostMapping("/register")
    public String reg(User user)
    {
        userService.saveUser(user);
        //登陆成功进入注册页面
        return "dl";
    }
    //登陆

@PostMapping("/dl")
public  String dd(String username, String password, HttpSession session,
                  RedirectAttributes redirectAttributes)
{
    User user= userService.checkUser(username,password);
    if((user == null||username.equals("admin")))
    { redirectAttributes.addFlashAttribute("message","用户名和密码错误");
        return "redirect:/user/dl";
        //失败重定向至原来页面
    }
    else {
        session.setAttribute("user",user);
        return "user/userIndex";
        //登陆成功进入下一页面 userIndex
    }
}
    @GetMapping("/dl")
    public String dl()
    {
        return "dl";
    }
    //删除

    @DeleteMapping("/delete")
    public JsonResult<User> delet(@PathVariable Integer id)
    {
       userService.deleteUser(id);
       return new JsonResult<>(OK,"删除成功");
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