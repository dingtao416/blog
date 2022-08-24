package com.myblog.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    //分页查询界面
    @GetMapping("/types")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Type> list = typeService.getTypes();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }
    //    返回新增分类页面
    @GetMapping("/types/input")
    public String input(){
        return "admin/types-input";
    }
    //  新增分类
    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            attributes.addFlashAttribute("message","类型名不能重复");
            return "redirect:/admin/types/input";
        }
        int t = typeService.saveType(type);
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/types";
    }

}
