package com.myblog.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TagService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.User;
import com.myblog.blog.quaryentity.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    //博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<BlogQuery> list = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo=new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }
    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types",typeService.getTypes());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }
    //博客新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        //新增的时候需要传递blog对象，blog对象需要有user
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //设置用户id
        blog.setUserId(blog.getUser().getId());

        int b = blogService.saveBlog(blog);
        if(b == 0){
            attributes.addFlashAttribute("message", "新增失败");
        }else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }
    @GetMapping("/blogs/search")
    public  String search()
    {
        return "admin/blogs::blogList";
    }
    @PutMapping("/blogs")
    //提交blog
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes)
    {
        blog.setUser((User)session.getAttribute("user")) ;
        blog.setType(typeService.getTypeByName(blog.getType().getName()));

      int t=blogService.saveBlog(blog);
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }

        return "redirect:/admin/blogs";
    }
}
