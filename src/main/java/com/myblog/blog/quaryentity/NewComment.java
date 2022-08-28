package com.myblog.blog.quaryentity;

/**
 * @Description: 最新评论实体类
 */
public class NewComment {

    private Integer id;
    private Long blogId;
    private String title;
    private String content;

    public NewComment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
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

    @Override
    public String toString() {
        return "NewComment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}