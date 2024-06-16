package com.mi.demo.controller;

import com.mi.demo.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(String nickname) {
        return "你好"+nickname;
    }
    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    public String demo2(String username, String password){
        System.out.println(username);
        System.out.println(password);
        return "POST请求";
    }
    @RequestMapping(value = "/demo3", method = RequestMethod.POST)
    public String demo3(User user){
        System.out.println(user);
        return "POST请求";
    }
    @RequestMapping(value = "/demo4", method = RequestMethod.POST)
    public String demo4(@RequestBody User user){
        System.out.println(user);
        return "POST请求";
    }
}
