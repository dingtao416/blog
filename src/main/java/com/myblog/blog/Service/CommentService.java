package com.myblog.blog.Service;

import com.myblog.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    //根据博客id查询评论信息
    List<Comment> listCommentByBlogId(Integer blogId);
    //添加保存评论
    int saveComment(Comment comment);
    //删除评论
    void deleteComment(Comment comment,Integer id);
}
