package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Type;
import com.myblog.blog.mapper.Typemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @Override
    public int updateType(Type type) {
        return typemapper.updateType(type);
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
}
