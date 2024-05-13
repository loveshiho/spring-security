package com.akai.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.HashMap;

public class AuthenticationEntryPointConfig implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        HashMap result = new HashMap<>();
        result.put("code", "-1");
        result.put("message", "需要登录");
        // 将结果对象转换成 json字符串
        String json = JSON.toJSONString(result);
        // 返回 json对象到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
