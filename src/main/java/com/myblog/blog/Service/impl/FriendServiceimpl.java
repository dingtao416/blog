package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.FriendService;
import com.myblog.blog.entity.FriendLink;
import com.myblog.blog.mapper.FriendLinkmapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceimpl implements FriendService {
private FriendLinkmapper friendLinkmapper;
    @Override
    public List<FriendLink> listFriendLink() {
        return friendLinkmapper.listFriendLink();
    }

    @Override
    public int saveFriendLink(FriendLink friendLink) {
        return friendLinkmapper.saveFriendLink(friendLink);
    }

    @Override
    public FriendLink getFriendLinkByBlogaddress(String blogaddress) {
        return friendLinkmapper.getFriendLinkByBlogaddress(blogaddress);
    }

    @Override
    public FriendLink getFriendLink(Long id) {
        return friendLinkmapper.getFriendLink(id);
    }

    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkmapper.updateFriendLink(friendLink);
    }

    @Override
    public void deleteFriendLink(Long id) {
                 friendLinkmapper.deleteFriendLink(id);
    }
}
