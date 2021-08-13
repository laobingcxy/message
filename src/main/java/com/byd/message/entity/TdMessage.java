package com.byd.message.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class TdMessage {

    private Long messageId;

    private String messageSender;

    private String messageApply;


    private Date messageTime;

    private String messageContent;

    private String messageReceiver;

    private String messateType;

    private String agentId;
    private Integer flag;
    private String realSender;


}
