package com.akai.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;

public class AuthenticationFailureHandlerConfig implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String localizedMessage = exception.getLocalizedMessage();
        HashMap result = new HashMap<>();
        result.put("code", "-1");
        result.put("message", localizedMessage);
        // 将结果对象转换成 json字符串
        String json = JSON.toJSONString(result);
        // 返回 json对象到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
