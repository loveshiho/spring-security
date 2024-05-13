package com.akai.service.impl;

import com.akai.mapper.UserMapper;
import com.akai.pojo.User;
import com.akai.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
