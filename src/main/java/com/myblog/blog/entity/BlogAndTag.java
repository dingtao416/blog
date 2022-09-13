package com.myblog.blog.entity;

public class BlogAndTag {
    Integer blogId;
    Integer tagId;

    public BlogAndTag() {
    }

    public BlogAndTag(Integer blogId, Integer tagId) {
        this.blogId = blogId;
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "BlogAndTag{" +
                "blogId=" + blogId +
                ", tagId=" + tagId +
                '}';
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
