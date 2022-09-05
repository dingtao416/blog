package com.myblog.blog.controller.user;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.controller.baseController;
import com.myblog.blog.entity.User;
import com.myblog.blog.quaryentity.FollowEntity;
import com.myblog.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     public String reg(User user,Model model)
     {
         User user1 = userService.judgeUser(user.getUsername());
         if(user1!=null)
         {
             model.addAttribute("message","用户名已存在");
             return "register";
         }
         else{
             userService.saveUser(user);
         }
        //注册成功进入登陆页面
        return "userLogin";
     }
     @GetMapping("/login")
     public  String login()
     {
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

@PostMapping("/login")
public  String dd(String username, String password, HttpSession session,
                  RedirectAttributes redirectAttributes)
{
    User user= userService.checkUser(username,password);
    if((user == null||username.equals("admin")))
    {
        redirectAttributes.addFlashAttribute("message","用户名和密码错误");
        return "redirect:/user/login";
        //失败重定向至原来页面
    }
    else {
        session.setAttribute("user",user);
        return "redirect:/";
        //登陆成功进入下一页面 userIndex
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

    /**
     * 关注
     * @param session
     * @param followId
     * @param model
     * @return
     */
    @GetMapping("/follow/{followId}")
    public  String follow(HttpSession session,@PathVariable  long followId,Model model)
    {
        User user = (User)session.getAttribute("user");
        long userId=user.getId();
        int hasFollowed;
        if(user!=null)
        {
            userService.saveFollower(userId,followId);
        }
        FollowEntity followed = userService.isFollowed(userId, followId);
        hasFollowed=followed==null?0:1;
        model.addAttribute("hasFollowed",hasFollowed);
        return "user::message";
    }

    /**
     * 取消关注
     * @param session
     * @param followId
     * @param model
     * @return
     */
    @GetMapping("/unfollow/{followId}")
    public String unfollow(HttpSession session,@PathVariable  long followId,Model model)
    {
        User user = (User)session.getAttribute("user");
        long userId=user.getId();
        int hasFollowed;
        if(user!=null)
        {
            userService.cancelFollow(userId,followId);
        }
        FollowEntity followed = userService.isFollowed(userId, followId);
        hasFollowed=followed==null?0:1;
        model.addAttribute("hasFollowed",hasFollowed);
        return "user::message";
    }

    /**
     * 根据id得到用户的信息
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String getDetailUser(@PathVariable Integer userId,Model model,HttpSession session)
    {
        User detailUser = userService.getDetailUser(userId);
        model.addAttribute("user",detailUser);
        User user = (User)session.getAttribute("user");
        long usrId=user.getId();
        int hasFollowed;
        FollowEntity followed = userService.isFollowed(usrId, userId);
        hasFollowed=followed==null?0:1;
        model.addAttribute("hasFollowed",hasFollowed);
        return "user";
    }
}