package com.akai.controller;

import com.akai.pojo.User;
import com.akai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/list")
    public List<User> getList() {
        return userService.list();
    }

    @RequestMapping("/add")
    public void addUser(User user) {
        System.out.println(user);
        userService.saveUserDetails(user);
    }
}
