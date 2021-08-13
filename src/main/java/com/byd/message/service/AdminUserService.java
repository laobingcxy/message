package com.byd.message.service;

import com.byd.message.domain.Result;
import com.byd.message.dto.AdminUserBean;
import com.byd.message.dto.AuthBean;
import com.byd.message.entity.AdminUser;

import java.util.List;

/**
 * 管理员用户(AdminUser)表服务接口
 *
 * @author makejava
 * @since 2021-08-06 09:49:58
 */
public interface AdminUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AdminUser queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<AdminUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser insert(AdminUser adminUser);

    /**
     * 修改数据
     *
     * @param adminUser 实例对象
     * @return 实例对象
     */
    AdminUser update(AdminUser adminUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Object userId);

    Result addUserAuth(AuthBean authBean);

    Result queryAuthList(int page,int pageSize,String query);

    Result updateUser(AdminUserBean adminUser);
}
