package com.byd.message.service.impl;

import com.byd.message.constant.MessageConstant;
import com.byd.message.domain.Result;
import com.byd.message.entity.TsApply;
import com.byd.message.mapper.TsApplyMapper;
import com.byd.message.service.TsApplyService;
import com.byd.message.util.HttpServletUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TsApplyServiceImpl implements TsApplyService {
    @Autowired
    private TsApplyMapper tsApplyMapper;


    @Override
    public TsApply queryById(String applyId) {
        return this.tsApplyMapper.queryById(applyId);
    }

    @Override
    public Result getApply(int page, int size) {
        String userId = HttpServletUtils.getRequestHeader(MessageConstant.TOKEN);
        PageHelper.startPage(page, size);
        List<TsApply> tsApplies = tsApplyMapper.getApply(userId);
        PageInfo pageInfo = new PageInfo(tsApplies);
        return new Result().success(pageInfo);
    }

    @Override
    public List<TsApply> queryAll() {
        return tsApplyMapper.queryAll(null);
    }


    @Override
    public TsApply insert(TsApply tsApply) {
        this.tsApplyMapper.insert(tsApply);
        return tsApply;
    }

    @Override
    public TsApply update(TsApply tsApply) {
        this.tsApplyMapper.update(tsApply);
        return this.queryById(tsApply.getApplyId());
    }


    @Override
    public boolean deleteById(String applyId) {
        return this.tsApplyMapper.deleteById(applyId) > 0;
    }
}
