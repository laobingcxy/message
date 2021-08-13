package com.byd.message.mapper;


import com.byd.message.entity.TsApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TsApplyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param applyId 主键
     * @return 实例对象
     */
    TsApply queryById(String applyId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TsApply> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tsApply 实例对象
     * @return 对象列表
     */
    List<TsApply> queryAll(TsApply tsApply);

    /**
     * 新增数据
     *
     * @param tsApply 实例对象
     * @return 影响行数
     */
    int insert(TsApply tsApply);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TsApply> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TsApply> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TsApply> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TsApply> entities);

    /**
     * 修改数据
     *
     * @param tsApply 实例对象
     * @return 影响行数
     */
    int update(TsApply tsApply);

    /**
     * 通过主键删除数据
     *
     * @param applyId 主键
     * @return 影响行数
     */
    int deleteById(String applyId);

    List<TsApply> getApply(String userId);
}

