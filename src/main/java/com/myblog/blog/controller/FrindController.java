package com.myblog.blog.controller;

import com.myblog.blog.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class FrindController {
    //友链功能
    @Autowired
    private FriendService friendService;
    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks",friendService.listFriendLink());
        return "friends";
    }
}