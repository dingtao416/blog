package com.myblog.blog.controller.user;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.quaryentity.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import  com.myblog.blog.entity.Type;
import  com.myblog.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserTypesController {

        @Autowired
        private TypeService typeService;

        @Autowired
        private BlogService blogService;
    @GetMapping("/types")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, /*@PathVariable Long id,*/ Model model) {
        List<Type> types = typeService.getTypes();
        model.addAttribute("types", types);
        PageHelper.startPage(pageNum, 10000);
        PageInfo<BlogQuery> list=new PageInfo<>();
        //model.addAttribute("activeTypeId", id);
        return "admin/types";
    }
    }

