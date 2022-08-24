package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.mapper.Blogmapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BlogServiceimpl implements BlogService {
   private Blogmapper blogmapper;
    @Override
    public Blog getBlogByid(Integer id) {
        return  blogmapper.getBlogByid(id);
    }

    @Override
    public int saveBlog(Blog blog) {
      return blogmapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
       return blogmapper.updateBlog(blog);
    }
    @Transactional
    @Override
    public void deleteBlog(Integer id) {
         blogmapper.deletBlog(id);
    }


}

