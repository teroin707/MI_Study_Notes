package com.mi.demo.controller;

import com.mi.demo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/users/{id}")
    public String getUsers(@PathVariable int id) {
        return "根据ID查询用户信息";
    }
    @PostMapping("/users")
    public String addUser(User user) {
        return "新增用户";
    }
    @PutMapping("/users")
    public String updateUser(User user) {
        return "更新用户信息";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return "删除用户";
    }
}
