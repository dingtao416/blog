package com.myblog.blog.mapper;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.quaryentity.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Blogmapper {
    Blog getBlogByid(long id);
    List<BlogQuery> getAllBlogQuery();
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(Blog blog);
    //删除博客
    void deletBlog(long id);
    List<Blog> getAllBlog();
}
