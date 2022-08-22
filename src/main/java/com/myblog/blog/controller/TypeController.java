package com.myblog.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
@RequestMapping("/admin")
@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;
    //分页查询分类列表
    @GetMapping("/types")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum)
    {
        String orderBy="id desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Type> list=typeService.getTypes();
        PageInfo<Type> pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }
}
