package com.myblog.blog.Service;

import com.myblog.blog.entity.Blog;

public interface BlogService {
    Blog getBlogByid(Integer id);
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(Blog blog);
    //删除博客
    void deleteBlog(Integer id);
}