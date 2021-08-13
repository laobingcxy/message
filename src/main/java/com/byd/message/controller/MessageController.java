package com.byd.message.controller;


import com.byd.message.domain.Result;
import com.byd.message.domain.TextMessage;
import com.byd.message.service.MessageService;
import com.byd.message.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/10000001")
    public Result rev(@RequestBody TextMessage textMessage) throws Exception {

        //暂时处理文本+表情消息
        if (textMessage.getMsgType().equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

            messageService.saveMes(textMessage, textMessage.getAppId());
        }
        return new Result().success("接收成功");
    }
}
