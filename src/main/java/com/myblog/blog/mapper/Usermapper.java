
package com.myblog.blog.mapper;
import com.myblog.blog.entity.User;
import com.myblog.blog.quaryentity.FollowEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Usermapper {
        //添加保存user
        int saveUser(User user);

        //根据id查询
        User getUserById(Integer id);
        //根据分类名查询分类
        User getUserByName(String nickname);
        //修改分类
        int updateUser(User user);
        //删除分类
        void deleteUser(Integer id);
        //根据用户名和密码查询检验用户
        User getAllUsernameandPassword(String username,String password);
        //根据username查询用户
        @Select("select * from t_user where username=#{username}")
        User judgeUser(String username);
         //添加关注
        int saveFollower(long userId,long followId);
        //删除关注
        int cancelFollow(long userId,long followId);
        //查找全部关注
        List<User> selectAllFollowers(long userId);
        //修改关注
        int updateFollow(long userId);
        FollowEntity isFollowed(long userId,long followId);
}
