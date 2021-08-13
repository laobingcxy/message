package com.byd.message.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class AdminUserBean extends CommonBean {

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
    /**
     * 创建时间
     */
    @JSONField(format = "yyyy/MM/dd HH:mm:ss")
    private Date ctime;

    private Integer enable;


}
