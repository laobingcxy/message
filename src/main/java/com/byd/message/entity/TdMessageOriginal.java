package com.byd.message.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TdMessageOriginal {

    private Long id;
    /**
     * 应用id
     */
    private String appid;
    /**
     * 原始报文
     */
    private String content;
    /**
     * 接收时间
     */
    private Date insertTime;



}
