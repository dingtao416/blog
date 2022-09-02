package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.UserService;
import com.myblog.blog.entity.Tag;
import com.myblog.blog.entity.User;
import com.myblog.blog.mapper.Usermapper;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println(user);
        return  usermapper.saveUser(user);
    }
    @SneakyThrows
    @Transactional
    @Override
    public int updateUser(User user) {
        /*User user1=usermapper.getUserById(user.getId());
        if(user1 == null)
        {
            throw new NotFoundException("该用户不存在");
        }
        else
            BeanUtils.copyProperties(user1,user);
        return usermapper.saveUser(user1);*/
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
