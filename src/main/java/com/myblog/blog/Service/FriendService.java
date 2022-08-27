package com.myblog.blog.Service;

import com.myblog.blog.entity.FriendLink;

import java.util.List;

public interface FriendService {
    //查询友链管理列表
    List<FriendLink> listFriendLink();

    //新增友链
    int saveFriendLink(FriendLink friendLink);

    //根据网址查询友链
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    //根据id查询友链
    FriendLink getFriendLink(Long id);

    //编辑修改友链
    int updateFriendLink(FriendLink friendLink);

    //删除友链
    void deleteFriendLink(Long id);
}
