package com.byd.message.controller;

import com.byd.message.constant.MessageConstant;
import com.byd.message.domain.FUser;
import com.byd.message.domain.Result;
import com.byd.message.domain.UserInfo;
import com.byd.message.util.CacheUtil;
import com.byd.message.util.HttpServletUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("10003001")
    public Result login(@RequestBody FUser fuser) {
        if (fuser.getFname().equals("123")) {
            UserInfo res = new UserInfo();
            res.setUsrLogin("123");
            res.setDisplayName("测试");
            res.setToken("123");
            CacheUtil.put("123", res, 1800);
            return new Result().success(res);
        }
        //你的业务逻辑

        return new Result().fail("账号或密码错误,请重新输入");
    }

    @GetMapping("10003002")
    public Result logout() {
        String userId = HttpServletUtils.getRequestHeader(MessageConstant.TOKEN);
        CacheUtil.remove(userId);
        return new Result().success("退出成功");
    }


    @GetMapping("10003003")
    public Result queryUserInfo() {
        String userId = HttpServletUtils.getRequestHeader(MessageConstant.TOKEN);
        CacheUtil.remove(userId);
        return new Result().success("退出成功");

    }


}