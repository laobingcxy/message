package com.byd.message.service.impl;

import com.byd.message.constant.MessageConstant;
import com.byd.message.controller.MyWebSocket;
import com.byd.message.domain.Message;
import com.byd.message.domain.MyReplyMessage;
import com.byd.message.domain.Result;
import com.byd.message.entity.TdMessage;
import com.byd.message.mapper.TdMessageMapper;
import com.byd.message.service.TdMessageService;
import com.byd.message.util.HttpServletUtils;
import com.byd.message.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


@Service
public class TdMessageServiceImpl implements TdMessageService {
    @Autowired
    private TdMessageMapper tdMessageMapper;


    @Override
    public TdMessage queryById(Long messageId) {
        return this.tdMessageMapper.queryById(messageId);
    }


    @Override
    public Result queryMessage(int page, int size, String id) {
        PageHelper.startPage(page, size);
        List<Message> messages = tdMessageMapper.queryMessageByApplyId(id);
        PageInfo pageInfo = new PageInfo(messages);
        return new Result().success(pageInfo);
    }


    @Override
    public TdMessage insert(TdMessage tdMessage) {
        this.tdMessageMapper.insert(tdMessage);
        return tdMessage;
    }


    @Override
    public TdMessage update(TdMessage tdMessage) {
        this.tdMessageMapper.update(tdMessage);
        return this.queryById(tdMessage.getMessageId());
    }


    @Override
    public boolean deleteById(String messageId) {
        return this.tdMessageMapper.deleteById(messageId) > 0;
    }

    @Override
    public Result queryMessageByApplyAndSender(int page, String sender, String apply) {
        PageHelper.startPage(page, 10);
        List<Message> messages = tdMessageMapper.queryMessageByApplyAndSender(sender, apply);
        Collections.reverse(messages);
        String url = "";
        String name = "";

        PageInfo pageInfo = new PageInfo(messages);
        String userId = HttpServletUtils.getRequestHeader(MessageConstant.TOKEN);
        if (page == 1) {
            MyWebSocket.getRecord().put(sender + ":" + apply + ":" + userId, messages.get(messages.size() - 1).getTime());
        }
        return new Result().success(pageInfo);
    }

    @Override
    @Transactional
    public Result saveMessageReply(MyReplyMessage replyMessage) {
        TdMessage tdMessage = new TdMessage();
        tdMessage.setMessageId(SnowFlake.getInstance().getNum());
        tdMessage.setMessageReceiver(replyMessage.getSender());
        tdMessage.setMessageApply(replyMessage.getApply());
        tdMessage.setMessageContent(replyMessage.getContent());
        tdMessage.setMessageTime(replyMessage.getTime());
        tdMessage.setMessateType(replyMessage.getType());
        tdMessage.setMessageSender(replyMessage.getApply());
        tdMessage.setRealSender(replyMessage.getUserId());
        tdMessage.setFlag(1);
        tdMessageMapper.insert(tdMessage);
        String userId = HttpServletUtils.getRequestHeader(MessageConstant.TOKEN);
        MyWebSocket.getRecord().put(replyMessage.getSender()
                + ":" + replyMessage.getApply() + ":" + userId, replyMessage.getTime());

        return new Result().success("发送成功");
    }


}
