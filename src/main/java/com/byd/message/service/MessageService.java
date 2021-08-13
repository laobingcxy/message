package com.byd.message.service;

import com.byd.message.domain.Message;
import com.byd.message.domain.TextMessage;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface MessageService {

    void saveOri(String appid, String content);

    void saveMes(TextMessage textMessage, String appId) throws ParseException;

    List<Message> getMessageLists(String userId);


    List<Message> queryMessageByApplyAndSender(String sender, String apply);

    List<Message> queryMessageByApplyAndSenderAndTime(String sender, String apply, Date date);
}
