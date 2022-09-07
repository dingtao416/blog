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
    public String list(Model model, @RequestParam(defaultValue = "1", value = "tagNum") Integer pageNum) {
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<Tag> list = tagService.getAllTag();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "tags";
    }

    @PostMapping("/tags/search/{id}")
    public String search(SearchBlog searchBlog, Model model,
                         @RequestParam(defaultValue = "1", value = "tagNum") Integer pageNum, @PathVariable Integer id) {
        List<Tag> tags = tagService.getAllTag();
        if (id == -1) {
            id = tags.get(0).getId();
        }
        List<BlogQuery> blogBySearch = blogService.getBlogBySearch(searchBlog);
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setPublished(true);
        PageHelper.startPage(pageNum, 10);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogBySearch);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        //model.addAttribute("pageInfo",blogService.getBlogBySearch(searchBlog));好像是简化了 emoj 不确定
         return "redirect:/tags/search";

    }
}


