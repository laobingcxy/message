package com.byd.message.entity;

public class AdminUserRole {

    /**
     * 用户编号
     */
    private String userId;
    /**
     * 角色编号
     */
    private Integer roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
