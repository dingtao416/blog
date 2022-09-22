package com.myblog.blog;

import com.myblog.blog.Service.*;
import com.myblog.blog.Service.impl.TagServiceimpl;
import com.myblog.blog.entity.*;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Tagmapper;
import com.myblog.blog.mapper.Typemapper;
import com.myblog.blog.mapper.Usermapper;
import com.myblog.blog.quaryentity.DetailedBlog;
import com.myblog.blog.quaryentity.FirstPageBlog;
import com.myblog.blog.quaryentity.UserQuery;
import com.myblog.blog.util.TimeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private Blogmapper blogmapper;
    @Autowired
    private TagServiceimpl tagService;
    @Autowired
    private Typemapper typemapper;
    @Autowired
    private Tagmapper tagmapper;
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private UserService userService;
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
        User user1=new User();
        user.setNickname("顶他");
        user.setUsername("2839");
        user.setPassword("456654546");
        user.setEmail("3563433349@qq.com");
        usermapper.updateUser(user);

    }
    @Test
    void findUser()
    {
        User user=new User();
        user.setNickname("蛋纯");
        User u = usermapper.getUserById(2);
        System.out.println(u);
        usermapper.saveUser(user);
    }
    @Test
    void deleteType()
    {
        List<Type> allTypesAndBlog = typeService.getAllTypesAndBlog();
        System.out.println(allTypesAndBlog);
    }
    @Test
    void getAll()
    {
        DetailedBlog detailedBlog = blogmapper.getDetailedBlog(16);
        System.out.println(detailedBlog);
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
        List<User> users = userService.selectAllFollowers(10);
        System.out.println(users);
    }
    @Test
    void comment()
    {
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        System.out.println(allFirstPageBlog);
    }
    @Test
    void Time()
    {
        boolean flag=new TimeUtil().offTime();
        System.out.println(flag);
    }
    @Test
    void Follower()
    {
        List<UserQuery> userBySearch = usermapper.getUserBySearch("牛");
        System.out.println(userBySearch);
    }
    @Test
    void tag()
    {
        System.out.println(blogmapper.getByTagId(11));
    }
}


