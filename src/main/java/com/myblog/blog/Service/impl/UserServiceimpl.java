package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Usermapper;
import com.myblog.blog.quaryentity.FollowEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
 private Usermapper usermapper;
    @Override
    public User checkUser(String username, String password) {
        return usermapper.getAllUsernameandPassword(username,password);
    }
    @Transactional
    @Override
    public int saveUser(User user) {
        String prefix="blog:";
        String nickname= UUID.randomUUID().toString();
        user.setNickname(prefix+nickname);
        return  usermapper.saveUser(user);
    }
    @SneakyThrows
    @Transactional
    @Override
    public int updateUser(User user) {

        return usermapper.updateUser(user);
    }
    @Transactional
    @Override
    public void deleteUser(Integer id) {
        usermapper.deleteUser(id);
    }

    @Override
    public void findUser(String nickname) {
        usermapper.getUserByName(nickname);
    }

    @Override
    public User judgeUser(String username) {
        return usermapper.judgeUser(username);
    }

    /**
     * 关注某人，同时更新用户关注数
     * @param userId
     * @param followId
     * @return
     */
    @Override
    public int saveFollower(long userId, long followId) {
        int i = usermapper.saveFollower(userId, followId);
        usermapper.updateFollow(userId);
        return i;
    }

    @Override
    public int cancelFollow(long userId, long followId) {
        return usermapper.cancelFollow(userId,followId);
    }

    @Override
    public List<User> selectAllFollowers(long userId) {
        return usermapper.selectAllFollowers(userId);
    }

    @Override
    public FollowEntity isFollowed(long userId, long followId) {
        return usermapper.isFollowed(userId,followId);
    }

    @Override
    public User getDetailUser(Integer userId) {
        return usermapper.getUserById(userId);
    }

    @Override
    public int updateFollow(long userId) {
        return usermapper.updateFollow(userId);
    }
}
