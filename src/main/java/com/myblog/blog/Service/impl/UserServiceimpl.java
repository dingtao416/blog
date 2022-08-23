package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return  usermapper.saveUser(user);
    }
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
}
