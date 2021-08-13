package com.byd.message.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MyReplyMessage {

    private String applyId;
    private String userId;
    private String name;
    private String agentId;
    private String apply;
    private String content;
    private String sender;
    private Date time;
    private String type;
}


