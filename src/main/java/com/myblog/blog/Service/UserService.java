package com.myblog.blog.Service;

import com.myblog.blog.entity.Type;
import com.myblog.blog.entity.User;

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
}
