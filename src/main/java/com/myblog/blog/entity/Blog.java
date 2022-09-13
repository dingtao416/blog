package com.myblog.blog.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//博客
public class Blog {
    //主键
    private Integer id;
    private String title;
    private  String content;
    private String firstPicture;
    private String flag;
    private  long views;
    private  long CommentCount;
    private boolean appreciation;
    private boolean commentabled;
    private long dayViews;
    private boolean shareStatement;
    private boolean recommend;
    private long ups;

    private boolean published;
    private Date createTime;
    private Date updateTime;
    private  String description;
    private  Type type;
    private  User user;
    private long typeId;
    private long userId;
    private List<Comment> comments=new ArrayList<>();
    private String tagIds;
    List<Tag> tags=new ArrayList<>();

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", CommentCount=" + CommentCount +
                ", appreciation=" + appreciation +
                ", commentabled=" + commentabled +
                ", dayViews=" + dayViews +
                ", shareStatement=" + shareStatement +
                ", recommend=" + recommend +
                ", ups=" + ups +
                ", published=" + published +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", user=" + user +
                ", typeId=" + typeId +
                ", userId=" + userId +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", tags=" + tags +
                '}';
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public long getDayViews() {
        return dayViews;
    }

    public void setDayViews(long dayViews) {
        this.dayViews = dayViews;
    }

    @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Blog)) return false;
        Blog blog = (Blog) o;
        return id == blog.id && appreciation == blog.appreciation && commentabled == blog.commentabled && recommend == blog.recommend && published == blog.published && typeId == blog.typeId && userId == blog.userId && Objects.equals(title, blog.title) && Objects.equals(content, blog.content) && Objects.equals(firstPicture, blog.firstPicture) && Objects.equals(flag, blog.flag) && Objects.equals(views, blog.views) && Objects.equals(CommentCount, blog.CommentCount) && Objects.equals(createTime, blog.createTime) && Objects.equals(updateTime, blog.updateTime) && Objects.equals(description, blog.description) && Objects.equals(type, blog.type) && Objects.equals(user, blog.user) && Objects.equals(comments, blog.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, firstPicture, flag, views, CommentCount, appreciation, commentabled, recommend, published, createTime, updateTime, description, type, user, typeId, userId, comments);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public long getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public long getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Integer commentCount) {
        CommentCount = commentCount;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }
    public void setViews(long views) {
        this.views = views;
    }

    public void setCommentCount(long commentCount) {
        CommentCount = commentCount;
    }

    public long getUps() {
        return ups;
    }

    public void setUps(long ups) {
        this.ups = ups;
    }

}
