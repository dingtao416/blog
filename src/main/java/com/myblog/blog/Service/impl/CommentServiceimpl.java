package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.CommentService;
import com.myblog.blog.entity.Comment;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Commentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private Commentmapper commentmapper;
    private List<Comment> tempReplys = new ArrayList<>();
    @Autowired
    private Blogmapper blogmapper;
    /**
     * @Description: 查询评论
     * @Auther: ONESTAR
     * @Date: 10:42 2020/6/23
     * @Param: blogId：博客id
     * @Return: 评论消息
     */
    @Override
    public List<Comment> listCommentByBlogId(Integer blogId) {
        //查询出父节点
        List<Comment> comments = commentmapper.findByBlogIdParentIdNull(blogId, Integer.parseInt("-1"));
        for(Comment comment : comments){
            Integer id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentmapper.findByBlogIdParentIdNotNull(blogId,id);
            //查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int i = commentmapper.saveComment(comment);
        blogmapper.getCommentCountById(comment.getBlogId());
        return  i;
    }

    @Override
    public void deleteComment(Comment comment, Integer id) {
        commentmapper.deleteComment(id);
        blogmapper.getCommentCountById(comment.getBlogId());
    }


    /**
     * @Description: 查询出子评论
     */
    private void combineChildren(Integer blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Integer childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }
    /**
     * @Description: 循环迭代找出子集回复
     */
    private void recursively(Integer blogId, Integer childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentmapper.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Integer replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }
}
