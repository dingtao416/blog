package com.myblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutmeController {
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
