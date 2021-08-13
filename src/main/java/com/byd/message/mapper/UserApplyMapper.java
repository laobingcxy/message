package com.byd.message.mapper;


import com.byd.message.entity.UserApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserApplyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    UserApply queryById(String applyId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserApply> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userApply 实例对象
     * @return 对象列表
     */
    List<UserApply> queryAll(UserApply userApply);

    /**
     * 新增数据
     *
     * @param userApply 实例对象
     * @return 影响行数
     */
    int insert(UserApply userApply);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserApply> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserApply> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserApply> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserApply> entities);

    /**
     * 修改数据
     *
     * @param userApply 实例对象
     * @return 影响行数
     */
    int update(UserApply userApply);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 影响行数
     */
    int deleteById(String applyId);

}

