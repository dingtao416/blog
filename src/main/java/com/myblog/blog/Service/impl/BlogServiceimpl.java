package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.quaryentity.BlogQuery;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceimpl implements BlogService {
    @Autowired
   private Blogmapper blogmapper;
    @Override
    public Blog getBlogByid(long id) {
        return  blogmapper.getBlogByid(id);
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogmapper.saveBlog(blog);
    }

    @SneakyThrows
    @Override
    public int updateBlog(Blog blog) {
        return blogmapper.saveBlog(blog);
    }
    @Transactional
    @Override
    public void deleteBlog(long id) {
         blogmapper.deletBlog(id);
    }
    //查询文章列表
    @Override
    public List<BlogQuery> getAllBlog() {
       return blogmapper.getAllBlogQuery();
    }


}

