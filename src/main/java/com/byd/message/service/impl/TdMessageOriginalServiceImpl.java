package com.byd.message.service.impl;


import com.byd.message.mapper.TdMessageOriginalMapper;
import com.byd.message.entity.TdMessageOriginal;
import com.byd.message.service.TdMessageOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TdMessageOriginalServiceImpl implements TdMessageOriginalService {
    @Autowired
    private TdMessageOriginalMapper tdMessageOriginalMapper;


    @Override
    public TdMessageOriginal queryById(Long id) {
        return this.tdMessageOriginalMapper.queryById(id);
    }


    @Override
    public List<TdMessageOriginal> queryAllByLimit(int offset, int limit) {
        return this.tdMessageOriginalMapper.queryAllByLimit(offset, limit);
    }


    @Override
    public TdMessageOriginal insertOri(TdMessageOriginal tdMessageOriginal) {
        this.tdMessageOriginalMapper.insertOri(tdMessageOriginal);
        return tdMessageOriginal;
    }


    @Override
    public TdMessageOriginal update(TdMessageOriginal tdMessageOriginal) {
        this.tdMessageOriginalMapper.update(tdMessageOriginal);
        return this.queryById(tdMessageOriginal.getId());
    }


    @Override
    public boolean deleteById(String id) {
        return this.tdMessageOriginalMapper.deleteById(id) > 0;
    }
}
