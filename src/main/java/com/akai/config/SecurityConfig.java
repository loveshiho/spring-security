package com.akai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authorizeRequests()：开启授权保护
        // anyRequest()：对所有请求开启授权保护
        // authenticated()：已认证请求会自动被授权
        // 开启授权保护
        http.authorizeRequests(authorize -> authorize.
                        // 对所有请求开启授权保护
                                anyRequest().
                        // 已认证请求会自动被授权
                                authenticated())
                // withDefaults()：生成默认的登录和登出页面
                .formLogin(withDefaults());  // 表单授权方式
                // .httpBasic(withDefaults()); // 基本授权方式
        // 关闭csrf攻击防御
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
    /*@Bean
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
    }*/
   /* @Bean
    public UserDetailsService userDetailsService() {
        // 创建基于数据库的用户信息管理器
        DBUserDetailsManager manager = new DBUserDetailsManager();
        return manager;
    }*/
}
