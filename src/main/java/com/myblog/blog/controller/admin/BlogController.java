package com.myblog.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TagService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.channels.Pipe;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<Blog> list = blogService.getAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }
    @GetMapping("/blogs/search")
    public  String search()
    {
        return "admin/blogs::blogList";
    }
    @GetMapping("/blogs/input")
    public  String input(Model model)
    {
        model.addAttribute("types",typeService.getTypes());
        model.addAttribute("tags",tagService.getAllTag());
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }

}
