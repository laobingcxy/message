package com.byd.message.controller;

import com.byd.message.domain.Result;
import com.byd.message.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminRoleController {

    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping("10007001")
    public Result roleLists() {
        return adminRoleService.roleLists();
    }

}
