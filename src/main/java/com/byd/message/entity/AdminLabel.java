package com.byd.message.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminLabel {

    /**
     * 标签id
     */
    private Object labelId;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 标签枚举值
     */
    private String title;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 排序
     */
    private Long orders;


}
