package com.myblog.blog.Service.impl;

import com.myblog.blog.Service.MessageService;
import com.myblog.blog.entity.Message;
import com.myblog.blog.mapper.Messagemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageServiceimpl implements MessageService {
    @Autowired
    private Messagemapper messagemapper;
    private List<Message> tempReplys = new ArrayList<>();
    //方法1：查找留言，使用递归迭代
    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messagemapper.findByReplayId(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }
    //方法2：调用查找所有留言方法，查询回复
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }
    @Override
    public List<Message> listMessage() {
        List<Message> messages = messagemapper.findByParentIdNull(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messagemapper.findByParentIdNotNull(id);
            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    @Override
    public int saveMessage(Message message,Message parentmessage) {
        return messagemapper.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
   messagemapper.deleteMessage(id);
    }

    @Override
    public Message getEmailByParentId(Long parentId) {
       return  messagemapper.getEmailByParentId(parentId);
    }

    @Override
    public List<Message> findAllmessage() {
        return messagemapper.findAllmessage();
    }
}
