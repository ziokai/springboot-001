package com.zou.controller;

import com.zou.bean.zou.User;
import com.zou.errorPackage.ResultResponse;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zou
 * @data 20222022/11/290:04
 */
@RestController
@RequestMapping("/testJasypt")
public class TestJasypt {


    @PostMapping("/requestJasypt")
    public ResultResponse requestJasypt() {

        //该类的选择根据algorithm：PBEWithMD5AndDE选择的算法选择
        BasicTextEncryptor encryptor = new BasicTextEncryptor();

        //设置密钥
        encryptor.setPassword("pkslow");

        String encrypt = encryptor.encrypt("root");
        System.out.println("数据库密码root加密后的结果" + encrypt);

        String decrypt = encryptor.decrypt(encrypt);
        System.out.println("解密后的结果" +decrypt);

        return ResultResponse.success();
    }

    /**
     * yml配置文件
     * jasypt:
     *     encryptor:
     *     password: pkslow #加密秘钥
     *     algorithm: PBEWithMD5AndDES #加密类型
     *     iv-generator-classname: org.jasypt.iv.NoIvGenerator #加密类型和这个要一一对应
     *
     *        <dependency>
     *             <groupId>com.github.ulisesbocchio</groupId>
     *             <artifactId>jasypt-spring-boot</artifactId>
     *             <version>3.0.4</version>
     *        </dependency>
     *
     */



}
