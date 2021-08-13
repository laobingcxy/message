package com.byd.message.controller;

import com.byd.message.domain.Result;
import com.byd.message.service.AdminLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminLabelController {

    @Autowired
    private AdminLabelService adminLabelService;

    /**
     *  查询标签页
     * @param userId
     * @return
     */
    @GetMapping("10005001")
    public Result queryLabs(String userId) {
        return adminLabelService.queryLabs(userId);
    }
}
