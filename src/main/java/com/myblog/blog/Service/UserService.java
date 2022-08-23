package com.myblog.blog.Service;

import com.myblog.blog.entity.User;

public interface UserService {
    //根据username 和password查询user是否存在，存在返回user
       User checkUser(String username, String password);

   


}
