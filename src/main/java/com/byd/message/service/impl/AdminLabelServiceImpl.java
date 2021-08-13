package com.byd.message.service.impl;

import com.byd.message.domain.Result;
import com.byd.message.entity.AdminLabel;
import com.byd.message.mapper.AdminLabelMapper;
import com.byd.message.service.AdminLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminLabelServiceImpl implements AdminLabelService {
    @Autowired
    private AdminLabelMapper adminLabelMapper;


    @Override
    public AdminLabel queryById(Object labelId) {
        return this.adminLabelMapper.queryById(labelId);
    }


    @Override
    public List<AdminLabel> queryAllByLimit(int offset, int limit) {
        return this.adminLabelMapper.queryAllByLimit(offset, limit);
    }


    @Override
    public AdminLabel insert(AdminLabel adminLabel) {
        this.adminLabelMapper.insert(adminLabel);
        return adminLabel;
    }


    @Override
    public AdminLabel update(AdminLabel adminLabel) {
        this.adminLabelMapper.update(adminLabel);
        return this.queryById(adminLabel.getLabelId());
    }

    @Override
    public boolean deleteById(Object labelId) {
        return this.adminLabelMapper.deleteById(labelId) > 0;
    }

    @Override
    public Result queryLabs(String userId) {
        return new Result().success(adminLabelMapper.queryLabs(userId));
    }
}
