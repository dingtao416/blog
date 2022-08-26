package com.myblog.blog.Service;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.quaryentity.BlogQuery;

import java.util.List;

public interface BlogService {
    Blog getBlogByid(long id);
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(Blog blog);
    //删除博客
    void deleteBlog(long id);
    List<BlogQuery> getAllBlog();
}
