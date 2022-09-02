package com.myblog.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myblog.blog.Service.MessageService;
import com.myblog.blog.entity.Message;
import com.myblog.blog.entity.User;
import com.myblog.blog.zujie.AccessLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping()
//@PropertySource("classpath:application.yml")
    public class MessageController {

        @Autowired
        private MessageService messageService;
        @Value("${message.avatar}")
         String avatar;

        @GetMapping("/message")
        public String message(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
            PageHelper.startPage(pageNum,15);
            List<Message> messages = messageService.listMessage();
            PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
            model.addAttribute("messages", pageInfo);
            return "message";
        }

        //    查询留言
        @GetMapping("/messagecomment")
        public String messages(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {

            PageHelper.startPage(pageNum,15);
            List<Message> messages = messageService.listMessage();
            PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
            model.addAttribute("messages", pageInfo);

            return "message::messageList";
        }

        //    新增留言
        @PostMapping("/message")
        @AccessLimit(seconds = 15, maxCount = 3)//15秒内 允许请求3次
        public String post(Message message, HttpSession session, Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
            User user = (User) session.getAttribute("user");
            //设置头像
            if (user != null) {
                message.setAvatar(user.getAvatar());
                message.setAdminMessage(true);
            } else {
                message.setAvatar(avatar);
            }
            Long parentId = message.getParentMessage().getId();
            Message parentMessage = null;
            if (parentId != null) {
                message.setParentMessageId(parentId);
                // 根据父评论id查询留言信息
                parentMessage = messageService.getEmailByParentId(parentId);
            }
            messageService.saveMessage(message,parentMessage);

            PageHelper.startPage(pageNum,15);
            List<Message> messages = messageService.listMessage();
            PageInfo<Message> pageInfo = new PageInfo<Message>(messages);
            model.addAttribute("messages", pageInfo);
            return "message";

            // return "redirect:/message";
        }

        //    删除留言
        @GetMapping("/messages/{id}/delete")
        public String delete(@PathVariable Long id, RedirectAttributes attributes, Model model,HttpSession session){
            User user = (User) session.getAttribute("user");
            if(user != null){
                messageService.deleteMessage(id);
            }
            return "redirect:/message";
        }
    }
