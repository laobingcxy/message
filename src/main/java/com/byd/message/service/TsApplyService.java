package com.byd.message.service;

import com.byd.message.domain.Result;
import com.byd.message.entity.TsApply;

import java.util.List;

/**
 * 应用表(TsApply)表服务接口
 *
 * @author makejava
 * @since 2021-07-20 15:45:45
 */
public interface TsApplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    TsApply queryById(String applyId);

    /**
     *   分页查询应用列表
     * @param page
     * @param size
     * @return
     */
    Result getApply(int page, int size);


    List<TsApply> queryAll();
    /**
     * 新增数据
     *
     * @param tsApply 实例对象
     * @return 实例对象
     */
    TsApply insert(TsApply tsApply);

    /**
     * 修改数据
     *
     * @param tsApply 实例对象
     * @return 实例对象
     */
    TsApply update(TsApply tsApply);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 是否成功
     */
    boolean deleteById(String applyId);

}
