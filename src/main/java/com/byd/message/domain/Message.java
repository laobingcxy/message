package com.byd.message.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Message {

    private String applyId;
    private String userId;
    private String name;
    private String url;
    private String agentId;
    private String apply;
    private String content;
    private String id;
    private String receiver;
    private String sender;
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date time;
    private String type;
    private Integer flag;
    private String realSender;
}
