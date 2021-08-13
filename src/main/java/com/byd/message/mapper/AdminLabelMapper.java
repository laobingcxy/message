package com.byd.message.mapper;

import com.byd.message.entity.AdminLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AdminLabelMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param labelId 主键
     * @return 实例对象
     */
    AdminLabel queryById(Object labelId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminLabel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminLabel 实例对象
     * @return 对象列表
     */
    List<AdminLabel> queryAll(AdminLabel adminLabel);

    /**
     * 新增数据
     *
     * @param adminLabel 实例对象
     * @return 影响行数
     */
    int insert(AdminLabel adminLabel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdminLabel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AdminLabel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdminLabel> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AdminLabel> entities);

    /**
     * 修改数据
     *
     * @param adminLabel 实例对象
     * @return 影响行数
     */
    int update(AdminLabel adminLabel);

    /**
     * 通过主键删除数据
     *
     * @param labelId 主键
     * @return 影响行数
     */
    int deleteById(Object labelId);

    List<AdminLabel> queryLabs(String userId);
}

