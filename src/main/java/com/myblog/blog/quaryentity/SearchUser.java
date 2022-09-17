package com.myblog.blog.quaryentity;

public class SearchUser {
    private Integer id;
    //昵称
    private String nickname;

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

    @Override
    public String toString() {
        return "SearchUser{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
