package com.byd.message.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.byd.message.constant.MessageConstant;
import com.byd.message.domain.Result;
import com.byd.message.dto.AdminAuthBean;
import com.byd.message.dto.AdminUserBean;
import com.byd.message.dto.AuthBean;
import com.byd.message.entity.AdminUser;
import com.byd.message.entity.AdminUserRole;
import com.byd.message.entity.TsApply;
import com.byd.message.entity.UserApply;
import com.byd.message.mapper.AdminUserMapper;
import com.byd.message.service.AdminUserService;
import com.byd.message.service.TsApplyService;
import com.byd.message.service.UserApplyService;
import com.byd.message.util.HttpServletUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;


    @Autowired
    UserApplyService userApplyService;

    @Autowired
    TsApplyService tsApplyService;


    @Override
    public AdminUser queryById(String userId) {
        return this.adminUserMapper.queryById(userId);
    }


    @Override
    public List<AdminUser> queryAllByLimit(int offset, int limit) {
        return this.adminUserMapper.queryAllByLimit(offset, limit);
    }


    @Override
    public AdminUser insert(AdminUser adminUser) {
        this.adminUserMapper.insert(adminUser);
        return adminUser;
    }

    @Override
    public AdminUser update(AdminUser adminUser) {
        this.adminUserMapper.update(adminUser);
        return this.queryById(adminUser.getUserId());
    }


    @Override
    public boolean deleteById(Object userId) {
        return this.adminUserMapper.deleteById(userId) > 0;
    }

    @Override
    @Transactional
    public Result addUserAuth(AuthBean authBean) {
        if (StringUtils.isEmpty(authBean.getUserId())) {
            return new Result().fail("请输入员工号");
        }

        AdminUserRole adminUserRole = adminUserMapper.queryUserExist(authBean.getUserId());
        if (ObjectUtil.isNotEmpty(adminUserRole)) {
            return new Result().fail("目前暂不支持重复添加角色,请联系开发者");
        }


        if (CollectionUtil.isEmpty(authBean.getApplyIds())) {
            if (authBean.getRoleId().equals("1")) {
                List<TsApply> tsApplies = tsApplyService.queryAll();
                if (CollectionUtil.isNotEmpty(tsApplies)) {
                    UserApply userApply;
                    List<UserApply> userApplies = new ArrayList<>();
                    for (TsApply s : tsApplies) {
                        userApply = new UserApply();
                        userApply.setUserId(authBean.getUserId());
                        userApply.setApplyId(s.getApplyId());

                        userApplies.add(userApply);
                    }
                    userApplyService.insertBatch(userApplies);

                }
            } else {
                return new Result().fail("应用列表为空");
            }
        } else {
            UserApply userApply;
            List<UserApply> userApplies = new ArrayList<>();
            for (String s : authBean.getApplyIds()) {
                userApply = new UserApply();
                userApply.setUserId(authBean.getUserId());
                userApply.setApplyId(s);
                userApplies.add(userApply);
            }
            userApplyService.insertBatch(userApplies);
        }


        //封装插入信息
        AdminUser user = AdminUser.builder()
                .userId(authBean.getUserId())
                .ctime(new Date())
                .enable(0)
                .cuser(HttpServletUtils.getRequestHeader(MessageConstant.TOKEN))
                //根据userId查询员工姓名
                .username("自定义")
                //根据userId查询员工头像
                .avatar("自定义").build();
        adminUserMapper.insert(user);
        adminUserMapper.inserRoleUser(user.getUserId(), authBean.getRoleId());
        return new Result().success("插入成功");
    }

    @Override
    public Result queryAuthList(int page, int pageSize, String query) {
        PageHelper.startPage(page, pageSize);
        List<AdminAuthBean> adminAuthBean = adminUserMapper.queryAuthList(query);
        PageInfo pageInfo = new PageInfo(adminAuthBean);
        return new Result().success(pageInfo);
    }

    @Override
    public Result updateUser(AdminUserBean adminUser) {
        //更新用户信息


        return null;
    }
}
