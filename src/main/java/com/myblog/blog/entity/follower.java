package com.myblog.blog.entity;

import java.util.Date;

public class follower {
    private long id;
    private long uid;
    private  long fid;
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "follower{" +
                "id=" + id +
                ", uid=" + uid +
                ", fid=" + fid +
                ", createTime=" + createTime +
                '}';
    }
}
