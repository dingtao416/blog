package com.myblog.blog.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//用户
public class User {
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private long fans;
    private long follows;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return fans == user.fans && follows == user.follows && Objects.equals(id, user.id) && Objects.equals(nickname, user.nickname) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(avatar, user.avatar) && Objects.equals(email, user.email) && Objects.equals(type, user.type) && Objects.equals(blogs, user.blogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, username, password, avatar, email, fans, follows, type, blogs);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", fans=" + fans +
                ", follows=" + follows +
                ", type=" + type +
                ", blogs=" + blogs +
                '}';
    }

    public Integer getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getFans() {
        return fans;
    }

    public void setFans(long fans) {
        this.fans = fans;
    }

    public long getFollows() {
        return follows;
    }

    public void setFollows(long follows) {
        this.follows = follows;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    private Integer type;

    private List<Blog> blogs=new ArrayList<>();

}
