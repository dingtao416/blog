package com.myblog.blog.mapper;

import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.BlogAndTag;
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
    //查询博客详情
    DetailedBlog getDetailedBlog(Integer id);
    //设置观看量
    int updateViews(Integer id);
    int getCommentCountById(Integer id);
    List<FirstPageBlog> getByTypeId(Integer typeId);
    int updateUps(Integer id);
    //搜索博客列表
    List<FirstPageBlog> getSearchBlog(String query);
    int updateDayViews(Integer id);
    int updateNewDayViews();
    //查询博客的数量
    int findNumofBlogs();
    //给博客表和标签中间表添加属性
    int saveBlogAndTag(BlogAndTag blogAndTag);
    DetailedBlog getDetailedBlogHasTag(Integer id);

    List<Blog> getByTagId(Integer tagId);
    List<BlogQuery> getBlogByUser(Integer id);
}
