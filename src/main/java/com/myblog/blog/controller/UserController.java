package com.myblog.blog.controller;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import com.myblog.blog.util.JsonResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/dl")
    public String dl()
    {
        return "dl";
    }
    @DeleteMapping("/delete")
    public JsonResult<User> delet(@PathVariable Integer id)
    {
       userService.deleteUser(id);
       return new JsonResult<>(OK,"删除成功");
    }
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
