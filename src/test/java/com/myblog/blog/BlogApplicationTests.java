package com.myblog.blog;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Typemapper;
import com.myblog.blog.mapper.Usermapper;
import lombok.extern.jbosslog.JBossLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private Blogmapper blogmapper;
    @Autowired
    private Typemapper typemapper;
    @Autowired
    private Usermapper usermapper;
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
        User user=new User();
        user.setNickname("蛋纯");
        user.setUsername("xxx2839");
        user.setPassword("456654546");
        user.setEmail("3563433349@qq.com");
        int i = usermapper.saveUser(user);
        System.out.println(i);
    }
    @Test
    void findUser()
    {
        User user=new User();
        user.setNickname("蛋纯");
        User u = usermapper.getUserById(2);
        System.out.println(u);
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
        Type t1 = new Type();
        t1.setName("springmvc");
        typemapper.saveType(t1);
        //typemapper.updateType(t1);
        System.out.println(t1);
    }
    @Test
    void blog()
    {
        Blog blog=new Blog();
        blog.setId(123);
       // blog.setTitle("帅锅");
       // blogmapper.saveBlog(blog);
       Blog blog1=blogmapper.getBlogByid(123);
        System.out.println(blog1);
    }


    }


