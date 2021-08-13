package com.byd.message.service;

import com.byd.message.domain.Result;
import com.byd.message.entity.AdminLabel;

import java.util.List;

/**
 * 标签页(AdminLabel)表服务接口
 *
 * @author makejava
 * @since 2021-08-06 09:47:11
 */
public interface AdminLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param labelId 主键
     * @return 实例对象
     */
    AdminLabel queryById(Object labelId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminLabel> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminLabel 实例对象
     * @return 实例对象
     */
    AdminLabel insert(AdminLabel adminLabel);

    /**
     * 修改数据
     *
     * @param adminLabel 实例对象
     * @return 实例对象
     */
    AdminLabel update(AdminLabel adminLabel);

    /**
     * 通过主键删除数据
     *
     * @param labelId 主键
     * @return 是否成功
     */
    boolean deleteById(Object labelId);

    Result queryLabs(String userId);
}
