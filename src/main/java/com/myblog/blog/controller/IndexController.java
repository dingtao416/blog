package com.myblog.blog.controller;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.quaryentity.DetailedBlog;
import com.myblog.blog.quaryentity.FirstPageBlog;
import com.myblog.blog.quaryentity.NewComment;
import com.myblog.blog.quaryentity.RecommendBlog;
import org.springframework.stereotype.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private Blogmapper blogmapper;
    @Autowired
    private TypeService typeService;
    //分页查询博客列表
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession session, RedirectAttributes attributes){
        PageHelper.startPage(pageNum,4);
        //查询博客列表
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        //查询最新推荐博客
        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        //查询最新评论
        List<NewComment> newComments = blogService.getNewComment();
        List<Type> types = typeService.getAllTypesAndBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        model.addAttribute("newComment",newComments);
        model.addAttribute("types",types);
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
    @GetMapping("/ups/{id}")
    public String upsControl(@PathVariable Integer id,Model model)
    {
        blogmapper.updateUps(id);
        model.addAttribute("blog",blogService.getBlogById(id));
        return "blog :: upsMessage";
    }
    //搜索博客
    @PostMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }
    @GetMapping("/index/message")
    public String message(Model model)
    {
        int numofBlogs = blogmapper.findNumofBlogs();
        model.addAttribute("blogTotal",numofBlogs);
        return "index::message";
    }
}
