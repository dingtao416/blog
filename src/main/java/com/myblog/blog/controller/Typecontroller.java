package com.myblog.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import com.myblog.blog.util.AjaxResult;
import com.myblog.blog.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/type")
public class Typecontroller {
    /**
     * 分页查询
     */
    @Autowired
    private TypeService typeService;
   public AjaxResult<PageInfo<Type>> list(Type type, Integer pagenum, Integer pagesize)
   {
       pagenum =pagenum ==null?1:pagenum;
       pagesize=pagesize ==null?1:pagenum;
       PageHelper.startPage(pagenum,pagesize);
       List<Type> temp=typeService.getTypes();
       PageInfo<Type> list =PageInfo.of(temp);
       return new AjaxResult<>(list);
   }


}
