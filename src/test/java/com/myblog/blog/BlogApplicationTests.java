package com.myblog.blog;

import com.myblog.blog.entity.Type;
import com.myblog.blog.mapper.Typemapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private Typemapper typemapper;
    @Test
    void contextLoads() {
    }

    @Test
    void getConnectionText()
    {
        System.out.println(typemapper);
    }
    @Test
    void InsertText()
    {
        Type t1=new Type();
        t1.setName("javaweb");
        typemapper.saveType(t1);
        System.out.println(t1);
    }
    @Test
    void findType()
    {
        Type t1 = typemapper.getTypeByName("javascript");
        Type t2 = typemapper.getTypeById(44);
        System.out.println(t1);
        System.out.println(t2);
    }
    @Test
    void deleteType()
    {
        typemapper.deleteType(44);
    }
    @Test
    void getAll()
    {
        List<Type> t = typemapper.getAllType();
        System.out.println(t);
    }
    @Test
    void change()
    {
        Type t1 = typemapper.getTypeByName("javaweb");
        t1.setName("springmvc");
        typemapper.updateType(t1);
        System.out.println(t1);
    }
}
