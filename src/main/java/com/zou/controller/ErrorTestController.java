package com.zou.controller;

import com.zou.bean.zou.User;
import com.zou.errorPackage.ResultResponse;
import com.zou.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/errorTest")
public class ErrorTestController {

    @Autowired
    UserServer userServer;

    @PostMapping("/add")
    public ResultResponse add(@RequestBody User user) {

        //如果姓名为空就手动抛出一个自定义的异常
        //if(true){
        //    throw  new BizException("-1","用户姓名不能为空！");
        //}

        //这里故意造成一个空指针的异常，并且不进行处理
        //String str = null;
        //str.equals("111");

        //这里故意造成一个异常，并且不进行处理
        //Integer.parseInt("abc123");

        //userServer.saveUser(user);

        return ResultResponse.success();
    }




}
