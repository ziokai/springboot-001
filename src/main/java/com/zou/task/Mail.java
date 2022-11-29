package com.zou.task;

import cn.hutool.core.util.StrUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Mail {

    @Async
    public void sendMail(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(StrUtil.format("邮件已发送，操作的线程是{}", Thread.currentThread().getName()));
    }

}
