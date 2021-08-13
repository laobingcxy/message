package com.byd.message.service;

import com.byd.message.domain.Result;
import com.byd.message.entity.AdminRole;

import java.util.List;

/**
 * 角色(AdminRole)表服务接口
 *
 * @author makejava
 * @since 2021-08-06 10:55:47
 */
public interface AdminRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    AdminRole queryById(Object roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    AdminRole insert(AdminRole adminRole);

    /**
     * 修改数据
     *
     * @param adminRole 实例对象
     * @return 实例对象
     */
    AdminRole update(AdminRole adminRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Object roleId);

    Result roleLists();
}
