package com.byd.message.service.impl;


import com.byd.message.domain.Message;
import com.byd.message.domain.TextMessage;
import com.byd.message.entity.TdMessage;
import com.byd.message.entity.TdMessageOriginal;
import com.byd.message.mapper.TdMessageMapper;
import com.byd.message.service.MessageService;
import com.byd.message.service.TdMessageOriginalService;
import com.byd.message.service.TdMessageService;
import com.byd.message.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    TdMessageOriginalService tdMessageOriginalService;

    @Autowired
    TdMessageService tdMessageService;

    @Autowired
    TdMessageMapper tdMessageMapper;

    @Override
    public void saveOri(String appId, String content) {
        TdMessageOriginal td = new TdMessageOriginal();
        td.setAppid(appId);
        td.setContent(content);
        td.setInsertTime(new Date());
        td.setId(SnowFlake.getInstance().getNum());
        tdMessageOriginalService.insertOri(td);
    }

    @Override
    public void saveMes(TextMessage textMessage, String appId) {
        TdMessage tdMessage = new TdMessage();
        tdMessage.setMessageId(textMessage.getMsgId());
        tdMessage.setMessageSender(textMessage.getFromUserName());
        tdMessage.setMessageApply(appId);
        tdMessage.setMessageTime(new Date(textMessage.getCreateTime() * 1000));
        tdMessage.setMessageContent(textMessage.getContent());
        tdMessage.setMessageReceiver(appId);
        tdMessage.setMessateType(textMessage.getMsgType());
        tdMessage.setAgentId(textMessage.getAgentID());
        tdMessage.setFlag(0);
        try {
            tdMessageService.insert(tdMessage);
        } catch (Exception e) {
            log.warn("消息重复,已过滤，id={}", textMessage.getMsgId(),e);
        }

    }

    @Override
    public List<Message> getMessageLists(String userId) {
        return tdMessageMapper.queryMessageByApplyId(userId);
    }

    @Override
    public List<Message> queryMessageByApplyAndSender(String sender, String apply) {
        return tdMessageMapper.queryMessageByApplyAndSender(sender, apply);
    }

    @Override
    public List<Message> queryMessageByApplyAndSenderAndTime(String sender, String apply, Date date) {
        return tdMessageMapper.queryMessageByApplyAndSenderAndTime(sender, apply, date);
    }

}
