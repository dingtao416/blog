package com.myblog.blog.Service.impl;

import com.github.pagehelper.Page;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.Type;
import com.myblog.blog.mapper.Typemapper;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
@Service
public class TypeServiceimpl implements TypeService {
    @Autowired

    private Typemapper typemapper;
    @Transactional
    @Override
    public int saveType(Type type) {
        return typemapper.saveType(type);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typemapper.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typemapper.getTypeByName(name);
    }
   @SneakyThrows
    @Transactional
    @Override
    public int updateType(Type type) {
        /*Type type1=typemapper.getTypeById(type.getId());
        if(type1 == null)
        {
           throw new NotFoundException("该类型不存在");
        }
        else
            BeanUtils.copyProperties(type1,type);
        return typemapper.saveType(type1);*/
       return  typemapper.updateType(type);

        
    }
    @Transactional
    @Override
    public void deleteType(Integer id) {
        typemapper.deleteType(id);
    }

    @Override
    public List<Type> getTypes() {
        return typemapper.getAllType();
    }

    @Override
    public List<Type> getAllTypesAndBlog() {
        return typemapper.getAllTypeAndBlog();
    }
}
