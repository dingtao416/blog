package com.myblog.blog.controller;


import com.myblog.blog.Service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @GetMapping("/picture")
    public String friends(Model model) {
       model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }
}
