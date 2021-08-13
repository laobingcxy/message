package com.byd.message.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthBean {

    private String userId;
    private String roleId;
    private List<String> applyIds;
}
