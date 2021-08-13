package com.byd.message.dto;

import lombok.Data;

@Data
public class BaseMessage {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private String MsgId;
    private String AgentID;

}
