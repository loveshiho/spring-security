package com.akai.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;

public class AuthenticationSuccessHandlerConfig implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Authentication存储用户对象信息
        Object principal = authentication.getPrincipal();   // 获取用户身份信息
        /*Object credentials = authentication.getCredentials();   // 获取用户凭证信息
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();   // 获取用户权限信息*/
        HashMap result = new HashMap<>();
        result.put("code", "0");
        result.put("message", "登录成功");
        result.put("data", principal);
        // 将结果对象转换成 json字符串
        String json = JSON.toJSONString(result);
        // 返回 json对象到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
