package com.myblog.blog.controller;

import com.myblog.blog.Service.BlogService;
import com.myblog.blog.Service.CommentService;
import com.myblog.blog.entity.Comment;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Blogmapper;
import com.myblog.blog.mapper.Commentmapper;
import com.myblog.blog.quaryentity.DetailedBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Value("${comment.avatar}")
    String avatar;
    //查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Integer blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }
    //新增评论
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, Model model) {
        Integer blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }
        Integer parentId = comment.getParentComment().getId();
        comment.setParentCommentId(parentId);
        commentService.saveComment(comment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }
    //删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Integer blogId, @PathVariable Integer id, Comment comment, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            commentService.deleteComment(comment,id);
        }
        DetailedBlog detailedBlog = blogService.getDetailedBlog(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "redirect:/comments"+blogId;
    }
}
