package com.byd.message.controller;

import com.byd.message.domain.Result;
import com.byd.message.dto.AdminUserBean;
import com.byd.message.dto.AuthBean;
import com.byd.message.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 添加用户权限
     *
     * @param authBean
     * @return
     */
    @PostMapping("10006001")
    public Result addUserAuth(@RequestBody AuthBean authBean) {
        return adminUserService.addUserAuth(authBean);
    }

    /**
     * 获取权限页数据列表
     *
     * @param page
     * @param pageSize
     * @param query
     * @return
     */
    @GetMapping("10006002")
    public Result queryAuthList(int page, int pageSize, String query) {
        return adminUserService.queryAuthList(page, pageSize, query);
    }

    @PostMapping("10006003")
    public Result updateUser(AdminUserBean adminUser) {
        return adminUserService.updateUser(adminUser);
    }

}
