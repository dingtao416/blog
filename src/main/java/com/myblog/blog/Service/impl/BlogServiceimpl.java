package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.TypeService;
import com.myblog.blog.entity.Blog;
import com.myblog.blog.entity.BlogAndTag;
import com.myblog.blog.entity.Tag;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.quaryentity.*;
import com.myblog.blog.util.MarkdownUtils;
import com.myblog.blog.util.TimeUtil;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceimpl implements BlogService {
    @Autowired
   private Blogmapper blogmapper;
    /**
     * 定时更新时间
     * @param id
     */

    @Override
    public ShowBlog getBlogById(Integer id) {
        return blogmapper.getBlogByid(id);
    }

    /**
     * 新增博客，初始化各种属性
     * @param blog
     * @return
     */
    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        blog.setUps(0);
        blogmapper.saveBlog(blog);
        Integer id = blog.getId();
        System.out.println(id);
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags=blog.getTags();
        BlogAndTag blogAndTag=null;
        for(Tag tag :tags)
        {
            blogAndTag=new BlogAndTag(id,tag.getId());
            blogmapper.saveBlogAndTag(blogAndTag);
        }
        return 1;
    }

    /**
     * 更新博客，修改更新时间
     * @param showBlog
     * @return
     */
    @Transactional
    @SneakyThrows
    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        List<Tag> tags = showBlog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(showBlog.getId(),tag.getId());
            blogmapper.saveBlogAndTag(blogAndTag);
        }
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

    /**
     * 查询博客时用的方法
     * @param searchBlog
     * @return
     */
    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogmapper.searchByTitleAndType(searchBlog);
    }

    /**
     * 首页返回博客
     * @return
     */
    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogmapper.getFirstPageBlog();
    }

    /**
     * 首页推荐博客
     * @return
     */
    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        return blogmapper.getAllRecommendBlog();
    }

    /**
     * 首页返回最新留言信息 ps:暂时用不到
     * @return
     */
    @Override
    public List<NewComment> getNewComment() {
        return blogmapper.getNewComment();
    }

    /**
     * 博客详情
     * @param id
     * @return
     */
    @Override
    public DetailedBlog getDetailedBlog(Integer id) {
        DetailedBlog detailedBlog = blogmapper.getDetailedBlogHasTag(id);
        if(detailedBlog==null)
        {
            detailedBlog=blogmapper.getDetailedBlog(id);
            if(detailedBlog==null)
            {
                throw new RuntimeException("博客未找到");
            }
        }
        String content = detailedBlog.getContent();
        content= MarkdownUtils.markdownToHtml(content);
        detailedBlog.setContent(content);
        if(new TimeUtil().offTime())
        {
            blogmapper.updateDayViews(id);
        }
        blogmapper.updateViews(id);
        blogmapper.getCommentCountById(id);
        return detailedBlog;
    }
    @Override
    public List<FirstPageBlog> getByTypeId(Integer typeId) {
        return blogmapper.getByTypeId(typeId);
    }
    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogmapper.getSearchBlog(query);
    }

    @Override
    public List<Blog> getByTagId(Integer id) {
        return blogmapper.getByTagId(id);
    }

    @Override
    public List<BlogQuery> getBlogByUser(Integer id) {
        return blogmapper.getBlogByUser(id);
    }

    @Override
    public List<BlogQuery> getUserSearchBlog(SearchUserBlog searchUserBlog) {
        return blogmapper.searchByTitleAndTypeAndUser(searchUserBlog);
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void updateNewDayViews()
    {
        blogmapper.updateNewDayViews();
    }
}

