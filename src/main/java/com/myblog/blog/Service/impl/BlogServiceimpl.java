package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.quaryentity.*;
import com.myblog.blog.util.MarkdownUtils;
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
    public ShowBlog getBlogById(Integer id) {
        return blogmapper.getBlogByid(id);
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
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogmapper.updateBlog(showBlog);
    }
    @Transactional
    @Override
    public void deleteBlog(Integer id) {
         blogmapper.deletBlog(id);
    }
    //查询文章列表
    @Override
    public List<BlogQuery> getAllBlog() {
       return blogmapper.getAllBlogQuery();
    }

    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogmapper.searchByTitleAndType(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogmapper.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        return blogmapper.getAllRecommendBlog();
    }

    @Override
    public List<NewComment> getNewComment() {
        return blogmapper.getNewComment();
    }

    @Override
    public DetailedBlog getDetailedBlog(Integer id) {
        DetailedBlog detailedBlog = blogmapper.getDetailedBlog(id);
        if(detailedBlog==null)
        {
            throw new RuntimeException("博客不存在");
        }
        String content = detailedBlog.getContent();
        content= MarkdownUtils.markdownToHtml(content);
        detailedBlog.setContent(content);
        blogmapper.updateViews(id);
        blogmapper.getCommentCountById(id);
        return detailedBlog;
    }

}

