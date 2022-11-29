package com.zou.controller;

import com.zou.bean.zou.User;
import com.zou.bean.query.UserQuery;
import com.zou.errorPackage.ResultResponse;
import com.zou.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mybatisTest")
public class mybatisController {

    @Autowired
    UserServer userServer;

    @PostMapping("/queryUserList")
    public ResultResponse saveUser() {
        List<User> userList = userServer.queryUserList();
        return ResultResponse.success(userList);
    }

    @PostMapping("/queryUserByName")
    public ResultResponse saveUser(@RequestBody UserQuery userQuery) {
        return ResultResponse.success(userServer.queryUserByName(userQuery));
    }


}
