package com.zou.controller;

import com.zou.bean.zou.User;
import com.zou.common.NeedAuth;
import com.zou.errorPackage.ResultResponse;
import com.zou.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping("/helloSpringBoot")
// @PropertySource("classpath:application.yml")
public class HelloController {

    @Autowired
    UserServer userServer;

//    @Value("${spring.datasource.driver-class-name}")
//    private String appid;

    @NeedAuth()
    @PostMapping("/hello")
    public String hello() {
        int[] array = {54,6,78,9,3,45,10};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        List<String> list = new ArrayList<>();
        Collections.sort(list);


        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, String> hashMapEntry : hashMap.entrySet()) {
            hashMapEntry.getKey();
            hashMapEntry.getValue();
        }
        for (String s : hashMap.keySet()){
            hashMap.get(s);
        };



        return "hello spring boot";
    }

    @PostMapping("/saveUser")
    public ResultResponse saveUser(@RequestBody @Validated User user) {
        userServer.saveUser(user);
        Map<String, String> map = new HashMap<>();
        map.put("1", "11");
        map.put("2", "22");
        map.put("3", "33");
        map.put("4", "44");
        return ResultResponse.success(map);
    }

    // 数据验证异常
    // 逻辑异常
    // .数据库链接异常
    // 第三方依赖的异常


}
