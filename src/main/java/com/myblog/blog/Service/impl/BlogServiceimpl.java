package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.mapper.Blogmapper;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceimpl implements BlogService {
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
        return blogmapper.saveBlog(blog);
    }

    @SneakyThrows
    @Override
    public int updateBlog(Blog blog) {
       /*Blog b=blogmapper.getBlogByid(blog.getId());
       if(b == null)
       {
           throw new NotFoundException("该博客不存在");
       }
       else
           BeanUtils.copyProperties(b,blog);
        return blogmapper.saveBlog(b);*/
        return blogmapper.updateBlog(blog);
    }
    @Transactional
    @Override
    public void deleteBlog(long id) {
         blogmapper.deletBlog(id);
    }

    @Override
    public List<Blog> getAllBlog() {
       return blogmapper.getAllBlog();
    }


}

