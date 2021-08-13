package com.byd.message.controller;

import com.byd.message.domain.Result;
import com.byd.message.service.TsApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TsApplyController {

    @Autowired
    private TsApplyService tsApplyService;

    @GetMapping("10004001")
    public Result getApply(int page, int size) {
        return tsApplyService.getApply(page, size);
    }
}
