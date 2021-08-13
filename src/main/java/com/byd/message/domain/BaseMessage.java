package com.byd.message.domain;

import lombok.Data;

@Data
public class BaseMessage {
    private String ToUserName;
    private String FromUserName;
    private Long CreateTime;
    private String MsgType;
    private Long MsgId;
    private String AgentID;
    private String appId;

}
