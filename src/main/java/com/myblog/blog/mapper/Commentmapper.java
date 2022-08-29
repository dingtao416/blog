package com.myblog.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.myblog.blog.entity.Comment;
@Mapper
@Repository
public interface Commentmapper {
    //根据博客id查询评论信息
    List<Comment> findByBlogIdParentIdNull(@Param("blogId")Integer blogId, @Param("blogParentId") Integer blogParentId);
    // 查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Integer blogId, @Param("id") Integer id);
    // 查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Integer blogId,@Param("childId") Integer childId);
    //添加保存评论
    int saveComment(Comment comment);
    //删除评论
    void deleteComment(Integer id);
}
