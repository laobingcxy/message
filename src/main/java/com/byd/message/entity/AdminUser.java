package com.byd.message.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder

public class AdminUser {

    /**
     * 编号
     */
    private String userId;
    /**
     * 帐号
     */
    private String username;
    /**
     * 姓名
     */
    private String realname;
    /**
     * 头像
     */
    private String avatar;
    private String cuser;
    /**
     * 创建时间
     */
    private Date ctime;

    private Integer enable;


}
