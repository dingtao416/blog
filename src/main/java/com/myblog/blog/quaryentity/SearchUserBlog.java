package com.myblog.blog.quaryentity;

public class SearchUserBlog {
    private String title;
    private Long typeId;
    private Long userId;

    @Override
    public String toString() {
        return "SearchUserBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", userId=" + userId +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
