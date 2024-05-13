package com.akai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser( // 此行设置断点可以查看创建的user对象
                User
                        .withDefaultPasswordEncoder()
                        .username("root") // 自定义用户名
                        .password("shiho") // 自定义密码
                        .roles("USER") // 自定义角色
                        .build()
        );
        return manager;
    }
}
