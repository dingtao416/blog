package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceimpl implements UserService {
    @Autowired
 private Usermapper usermapper;
    @Override
    public User checkUser(String username, String password) {
        return usermapper.getAllUsernameandPassword(password,username);
    }
}
