package com.byd.message.service;

import com.byd.message.entity.UserApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户应用关联表(UserApply)表服务接口
 *
 * @author makejava
 * @since 2021-08-10 16:08:16
 */
public interface UserApplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    UserApply queryById(String applyId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserApply> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userApply 实例对象
     * @return 实例对象
     */
    UserApply insert(UserApply userApply);

    int insertBatch(List<UserApply> entities);

    /**
     * 修改数据
     *
     * @param userApply 实例对象
     * @return 实例对象
     */
    UserApply update(UserApply userApply);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 是否成功
     */
    boolean deleteById(String applyId);

}
