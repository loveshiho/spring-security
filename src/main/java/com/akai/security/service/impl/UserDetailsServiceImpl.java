package com.akai.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 从数据库中获取的密码，应该是已经加密过的
        // 理解:password就是数据库中查询出来的密码，查询出来的内容不是 shiho
        String password = "shiho";
        String encodePassword = passwordEncoder.encode(password);
        UserDetails user = new User(username, encodePassword, AuthorityUtils.commaSeparatedStringToAuthorityList("超级管理员"));
        return user;
    }
}
