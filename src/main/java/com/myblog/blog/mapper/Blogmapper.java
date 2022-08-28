package com.myblog.blog.mapper;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.quaryentity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Blogmapper {
    ShowBlog getBlogByid(Integer id);
    List<BlogQuery> getAllBlogQuery();
    //增加博客
    int saveBlog(Blog blog);
    //修改博客
    int updateBlog(ShowBlog showBlog);
    //删除博客
    void deletBlog(long id);
    List<BlogQuery> searchByTitleAndType(SearchBlog searchBlog);
    //首页展示查询
    List<FirstPageBlog> getFirstPageBlog();
    //推荐博客
    List<RecommendBlog> getAllRecommendBlog();
    List<NewComment> getNewComment();
}
