package com.myblog.blog.controller;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Comment;
import com.myblog.blog.quaryentity.DetailedBlog;
import com.myblog.blog.quaryentity.FirstPageBlog;
import com.myblog.blog.quaryentity.NewComment;
import com.myblog.blog.quaryentity.RecommendBlog;
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
public class IndexController {
    @Autowired
    private BlogService blogService;

    //分页查询博客列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,4);
        //查询博客列表
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        //查询最新推荐博客
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        //查询最新评论
        List<NewComment> newComments = blogService.getNewComment();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        model.addAttribute("newComment",newComments);
        return "index";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Integer id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
//        List<Comment> comments = commentService.listCommentByBlogId(id);
//        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}
