package com.myblog.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Typemapper;
import com.myblog.blog.quaryentity.FirstPageBlog;
import com.myblog.blog.quaryentity.ShowBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @RequestMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @PathVariable Integer id, Model model){
        List<Type> allTypeAndBlog = typeService.getAllTypesAndBlog();
        if(id==-1)
        {
            if(!allTypeAndBlog.isEmpty()){
                id = allTypeAndBlog.get(0).getId();
            }
        }
        model.addAttribute("types",allTypeAndBlog);
        List<FirstPageBlog> byTypeId = blogService.getByTypeId(id);
        PageHelper.startPage(pageNum, 10000);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(byTypeId);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
