package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.CommentService;
import com.myblog.blog.entity.Comment;
import com.myblog.blog.mapper.Commentmapper;

import java.util.List;

public class CommentServiceimpl implements CommentService {
    private Commentmapper commentmapper;
    @Override
    public List<Comment> listCommentByBlogId(Long Id) {
        return null;
    }

    @Override
    public List<Comment> saveAllComment() {
        return null;
    }

    @Override
    public int saveComment(Comment comment, Comment parentComment) {
        return 0;
    }

    @Override
    public void deleteComment(Comment comment, Long id) {

    }

    @Override
    public Comment getEmailByParentId(Long parentCommentId) {
        return null;
    }
}
