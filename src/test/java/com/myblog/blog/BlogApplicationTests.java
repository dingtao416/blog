package com.myblog.blog;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.Service.FriendService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.*;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Typemapper;
import com.myblog.blog.mapper.Usermapper;
import com.myblog.blog.quaryentity.*;
import lombok.extern.jbosslog.JBossLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private Blogmapper blogmapper;
    @Autowired
    private Typemapper typemapper;
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TypeService typeService;
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
        List<Type> t = typemapper.getAllTypeAndBlog();
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
        int i = blogmapper.updateUps(17);
        System.out.println(i);
    }
    @Test
    void comment()
    {
        System.out.println(typemapper.getAllType());
    }
}


