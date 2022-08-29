package com.myblog.blog.Service;

import com.github.pagehelper.Page;
import com.myblog.blog.entity.Type;

import java.awt.print.Pageable;
import java.util.List;

public interface TypeService {
    //新增保存分类
    int saveType(Type type);
    //根据id查询分类
    Type getTypeById(Integer id);
    //根据分类名称查询分类
    Type getTypeByName(String name);
    //编辑修改分类
    int updateType(Type type);
    //删除分类
    void deleteType(Integer id);
    //查询所有分类
    List<Type> getTypes();
    List<Type> getAllTypesAndBlog();
}
