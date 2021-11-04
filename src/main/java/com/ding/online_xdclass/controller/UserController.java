package com.ding.online_xdclass.controller;

import com.ding.online_xdclass.service.UserService;
import com.ding.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Author 丁帅帅
 * @Date 21/11/04 16:46
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {

        int rows = userService.save(userInfo);
        return rows == 1 ? JsonData.buildSuccess(): JsonData.buildError("注册失败，请重试!!!");
    }
}