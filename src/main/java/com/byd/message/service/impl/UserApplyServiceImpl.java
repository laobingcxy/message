package com.byd.message.service.impl;

import com.byd.message.entity.UserApply;
import com.byd.message.mapper.UserApplyMapper;
import com.byd.message.service.UserApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserApplyServiceImpl implements UserApplyService {
    @Autowired
    private UserApplyMapper userApplyMapper;


    @Override
    public UserApply queryById(String applyId) {
        return this.userApplyMapper.queryById(applyId);
    }


    @Override
    public List<UserApply> queryAllByLimit(int offset, int limit) {
        return this.userApplyMapper.queryAllByLimit(offset, limit);
    }


    @Override
    public UserApply insert(UserApply userApply) {
        this.userApplyMapper.insert(userApply);
        return userApply;
    }

    @Override
    public int insertBatch(List<UserApply> entities) {
        return userApplyMapper.insertBatch(entities);
    }


    @Override
    public UserApply update(UserApply userApply) {
        this.userApplyMapper.update(userApply);
        return this.queryById(userApply.getApplyId());
    }


    @Override
    public boolean deleteById(String applyId) {
        return this.userApplyMapper.deleteById(applyId) > 0;
    }
}
