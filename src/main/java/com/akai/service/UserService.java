package com.akai.service;

import com.akai.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    void saveUserDetails(User user);
}
