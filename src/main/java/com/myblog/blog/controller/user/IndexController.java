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
    @GetMapping("/blogss")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,10);
        //查询博客列表
        List<Blog> allFirstPageBlog = blogService.getAllBlog();
        //查询评论
        List<Comment> newComments = commentService.saveAllComment();

        PageInfo<Blog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("newComment",newComments);
        return "index";
    }

    //搜索博客
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 1000);
        List<Blog> searchBlog = blogService.getAllBlog();

        PageInfo<Blog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }


}
