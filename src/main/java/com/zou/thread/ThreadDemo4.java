package com.zou.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zou
 * @data 20222022/11/3015:30
 *
 * Callable的方式实现多线程
 */
public class ThreadDemo4 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("hello thread, 【Callable方式】");
        return 999;
    }



    public static void main(String[] args) {
        FutureTask f = new FutureTask(new ThreadDemo4());
        Thread t = new Thread(f);
        t.start();
    }
}
