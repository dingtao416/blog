package com.myblog.blog.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TagService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Tag;


import java.util.List;

import com.myblog.blog.quaryentity.BlogQuery;
import com.myblog.blog.quaryentity.SearchBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TagShowController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1", value = "tagNum") Integer pageNum, @PathVariable Integer id) {
        List<Tag> tags = tagService.getBlogTag();
        //-1从导航点过来的
        if (id == -1){
            id = tags.get(0).getId();
        }
        List<Blog> blogs = blogService.getByTagId(id);
        System.out.println(id);
        model.addAttribute("tags", tags);
        model.addAttribute("activeTagId", id);
        return "tags";
    }
    @GetMapping("/tag/message")
    public String message(Model model)
    {
        int tags = tagService.FindNumOfTypes();
        model.addAttribute("tagTotal",tags);
        return "tags::message";
    }
}


