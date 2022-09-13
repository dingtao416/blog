package com.myblog.blog.Service;

import com.myblog.blog.entity.User;
import com.myblog.blog.quaryentity.FollowEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
       //根据username 和password查询user是否存在，存在返回user
       User checkUser(String username, String password);
       //增加新用户
       int saveUser(User user);
       //修改用户
       int updateUser(User user);
       //后台删除用户
       void deleteUser(Integer id);
       //根据昵称查找用户
       void findUser(String nickname);
       User judgeUser(String username);

       /**
        * 关注某人
        * @param userId
        * @param followId
        * @return
        */
       int saveFollower(long userId,long followId);

       /**
        * 取消关注某人
        * @param userId
        * @param followId
        * @return
        */
       int cancelFollow(long userId,long followId);

       /**
        * 查看所有关注数
        * @param userId
        * @return
        */
       List<User> selectAllFollowers(long userId);

       /**
        * 判断是否关注，主要返回前端数据
        * @param userId
        * @param followId
        * @return
        */
       FollowEntity isFollowed(long userId,long followId);

       /**
        * 得到具体的user信息，返回user前端页面
        * @param userId
        * @return
        */
       User getDetailUser(Integer userId);
       //修改关注数
       int updateFollow(long userId);

}
