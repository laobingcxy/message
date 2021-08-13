package com.byd.message.entity;

import lombok.Data;

import java.util.Date;


@Data
public class AdminRole {

    /**
     * 编号
     */
    private Object roleId;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色标题
     */
    private String title;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date ctime;
    /**
     * 排序
     */
    private Long orders;

}
