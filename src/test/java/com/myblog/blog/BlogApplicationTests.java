package com.myblog.blog;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.Service.MessageService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Message;
import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Typemapper;
import com.myblog.blog.mapper.Usermapper;
import com.myblog.blog.quaryentity.BlogQuery;
import com.myblog.blog.quaryentity.DetailedBlog;
import com.myblog.blog.util.TimeUtil;
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
    private MessageService messageService;
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
        int i = usermapper.updateFollow(4);
        System.out.println(i);
    }
    @Test
    void comment()
    {
        System.out.println(typemapper.getAllType());
    }
@Test
    void Message()
    {
        Date date=new Date();
        date.setTime(20005);
       Message message= new Message();
        message.setId(1l);
        message.setParentMessageId(1l);
        message.setCreateTime(date);
        Message message1= new Message();
        message1.setId(2l);
        message1.setCreateTime(date);
        messageService.saveMessage(message,message1);
        System.out.println(messageService.getEmailByParentId(1l));
        System.out.println(messageService.findAllmessage());
    }
    @Test
    void Time()
    {
        boolean flag=new TimeUtil().offTime();
        System.out.println(flag);
    }
}


