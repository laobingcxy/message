package com.byd.message.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class AdminAuthBean  {

    /**
     * 编号
     */
    private String userId;
    /**
     * 帐号
     */
    private String userName;

    /**
     * 头像
     */
    private String avatar;
    private String cUser;
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date cTime;

    private Integer enable;

    private String roleName;


}
