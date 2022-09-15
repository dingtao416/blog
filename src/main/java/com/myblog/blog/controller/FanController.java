package com.myblog.blog.controller;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FanController {
    @Autowired
    private UserService userService;
    @PostMapping("/follower/save/{followerid}")
    public int saveFollower(long userid,@PathVariable long followid)
    {
        return userService.saveFollower(userid,followid);
    }
    @PostMapping("/follower/delet/{followerid}")
            public void deletFollower(@PathVariable Integer followerid)
    {
       userService.deleteUser(followerid);
    }
    @GetMapping("/follower/select/{userid}")
    public String selectFollower(@PathVariable long userid, Model model)
    {
        List<User>  followers=userService.selectAllFollowers(userid);
        model.addAttribute("followers",followers);
        return  "followers";

    }

}
