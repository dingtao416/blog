package com.myblog.blog.controller.user;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Comment;
import org.springframework.stereotype.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class IndexController {
    @Autowired
    private BlogService blogService;
    private CommentService commentService;
    //分页查询博客列表


}
