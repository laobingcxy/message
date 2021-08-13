package com.byd.message.service.impl;

import com.byd.message.domain.Result;
import com.byd.message.entity.AdminRole;
import com.byd.message.mapper.AdminRoleMapper;
import com.byd.message.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;


    @Override
    public AdminRole queryById(Object roleId) {
        return this.adminRoleMapper.queryById(roleId);
    }


    @Override
    public List<AdminRole> queryAllByLimit(int offset, int limit) {
        return this.adminRoleMapper.queryAllByLimit(offset, limit);
    }


    @Override
    public AdminRole insert(AdminRole adminRole) {
        this.adminRoleMapper.insert(adminRole);
        return adminRole;
    }


    @Override
    public AdminRole update(AdminRole adminRole) {
        this.adminRoleMapper.update(adminRole);
        return this.queryById(adminRole.getRoleId());
    }


    @Override
    public boolean deleteById(Object roleId) {
        return this.adminRoleMapper.deleteById(roleId) > 0;
    }

    @Override
    public Result roleLists() {
        return new Result().success(adminRoleMapper.roleLists());
    }
}
