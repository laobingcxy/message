package com.byd.message.interceptor;


import com.alibaba.fastjson.JSON;
import com.byd.message.domain.Result;
import com.byd.message.domain.ResultCode;
import com.byd.message.util.CacheUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class VerificationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (CacheUtil.get(token) == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.write(JSON.toJSONString(new Result().result(ResultCode.NO_LOGIN)));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }

            log.info("用户未登录");
            return false;
        }
        return true;

    }


}
