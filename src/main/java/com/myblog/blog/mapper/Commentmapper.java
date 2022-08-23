package com.myblog.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.myblog.blog.entity.Comment;
@Mapper
@Repository
public interface Commentmapper {
    //添加comment
    void  savecomment(Comment comment);
    //根据id删除
    void  deletcommentByid(Integer id);
    //修改评论
    void updatecomment(Comment comment);
    //获取评论
    List<Comment> getAllcomment();


}
