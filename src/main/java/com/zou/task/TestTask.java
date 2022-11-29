package com.zou.task;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot定时任务
 * @Scheduled() 使用在要执行的方法上
 * @EnableScheduling 使用在启动类上
 * @EnableAsync 异步执行，放在启动类上
 * @Async 指定要异步执行的方法
 */
@Component
public class TestTask {

    @Autowired
    private Mail mail;

    // 每两秒钟执行一次
    @Scheduled(cron = "*/2 * * * * ?")
    public void test() throws InterruptedException {

        TimeInterval time = new TimeInterval();
        time.start();
        System.out.println(StrUtil.format("定时任务开始，线程名{}", Thread.currentThread().getName()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mail.sendMail();
        System.out.println(StrUtil.format("方法执行共耗时：{}", time.intervalPretty()));
    }

}