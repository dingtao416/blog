package com.myblog.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//评论
public class Comment {
    private Integer id;
    private String nickname;
    private String email;
    private String content;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blogId=" + blogId +
                ", parentCommentId=" + parentCommentId +
                ", adminComment=" + adminComment +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", parentNickname='" + parentNickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return blogId == comment.blogId && parentCommentId == comment.parentCommentId && adminComment == comment.adminComment && Objects.equals(id, comment.id) && Objects.equals(nickname, comment.nickname) && Objects.equals(email, comment.email) && Objects.equals(content, comment.content) && Objects.equals(avatar, comment.avatar) && Objects.equals(createTime, comment.createTime) && Objects.equals(replyComments, comment.replyComments) && Objects.equals(parentComment, comment.parentComment) && Objects.equals(parentNickname, comment.parentNickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, email, content, avatar, createTime, blogId, parentCommentId, adminComment, replyComments, parentComment, parentNickname);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public boolean isAdminComment() {
        return adminComment;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getParentNickname() {
        return parentNickname;
    }

    public void setParentNickname(String parentNickname) {
        this.parentNickname = parentNickname;
    }

    private String avatar;
    private Date createTime;
    private long blogId;
    private long parentCommentId;
    private boolean adminComment;

    private List<Comment> replyComments=new ArrayList<>();
    private Comment parentComment;
    private  String parentNickname;
}
