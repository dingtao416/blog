package com.myblog.blog.Service;

import com.myblog.blog.entity.Message;

import java.util.List;
public interface MessageService {
    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message,Message parentMessage);

    //删除留言
    void deleteMessage(Long id);


    Message getEmailByParentId(Long parentId);
    //查询所有
    List<Message> findAllmessage();
}
