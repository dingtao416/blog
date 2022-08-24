package com.myblog.blog.mapper;

import com.myblog.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Blogmapper {
    Blog getBlogByid(Integer id);
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(Blog blog);
    //删除博客
    void deletBlog(Integer id);
}
