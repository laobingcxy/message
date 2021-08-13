package com.byd.message.service;

import com.byd.message.entity.TdMessageOriginal;

import java.util.List;

/**
 * (TdMessageOriginal)表服务接口
 *
 * @author makejava
 * @since 2021-07-16 13:17:04
 */
public interface TdMessageOriginalService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TdMessageOriginal queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TdMessageOriginal> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tdMessageOriginal 实例对象
     * @return 实例对象
     */
    TdMessageOriginal insertOri(TdMessageOriginal tdMessageOriginal);

    /**
     * 修改数据
     *
     * @param tdMessageOriginal 实例对象
     * @return 实例对象
     */
    TdMessageOriginal update(TdMessageOriginal tdMessageOriginal);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
