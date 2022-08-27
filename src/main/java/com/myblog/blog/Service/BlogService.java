package com.myblog.blog.Service;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.quaryentity.BlogQuery;
import com.myblog.blog.quaryentity.ShowBlog;

import java.util.List;

public interface BlogService {
    ShowBlog getBlogById(Integer id);
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(ShowBlog showBlog);
    //删除博客
    void deleteBlog(Integer id);
    List<BlogQuery> getAllBlog();
}
