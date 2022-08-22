package com.myblog.blog.mapper;

import com.myblog.blog.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Typemapper {
    //添加保存分类
    int saveType(Type type);
    //根据id查询
    Type getTypeById(Integer id);
    //查询所有分类
    List<Type> getAllType();
    //根据分类名查询分类
    Type getTypeByName(String name);
    //修改分类
    int updateType(Type type);
    //删除分类
    void deleteType(Integer id);
}
