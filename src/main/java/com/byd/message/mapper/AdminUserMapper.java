package com.byd.message.mapper;


import com.byd.message.dto.AdminAuthBean;
import com.byd.message.entity.AdminUser;
import com.byd.message.entity.AdminUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AdminUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AdminUser queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param adminUser 实例对象
     * @return 对象列表
     */
    List<AdminUser> queryAll(AdminUser adminUser);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int insert(AdminUser adminUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdminUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AdminUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AdminUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<AdminUser> entities);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 影响行数
     */
    int update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Object userId);

    void inserRoleUser(@Param("userId") String userId, @Param("roleId") String roleId);

    List<AdminAuthBean> queryAuthList(@Param("query") String query);

    AdminUserRole queryUserExist(@Param("userId") String userId);
}

