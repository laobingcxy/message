package com.byd.message.controller;

import com.byd.message.domain.Employee;
import com.byd.message.domain.MyReplyMessage;
import com.byd.message.domain.Result;
import com.byd.message.service.TdMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    TdMessageService tdMessageService;

    @GetMapping("10002001")
    public Result getEmpMesLists(int page, int size, String id) {
        return tdMessageService.queryMessage(page, size, id);
    }

    @GetMapping("10002003")
    public Result queryMessageByApplyAndSender(int page, String sender, String apply) {
        return tdMessageService.queryMessageByApplyAndSender(page, sender, apply);
    }


    @PostMapping("10002004")
    public Result saveMessageReply(@RequestBody MyReplyMessage replyMessage) {
        return tdMessageService.saveMessageReply(replyMessage);
    }


}
