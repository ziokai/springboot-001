package com.zou.thread;

import java.util.concurrent.Callable;

/**
 * @author zou
 * @data 20222022/11/3011:14
 *
 * 内部类的方式实现多线程
 */
public class ThreadDemo3 {

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run(){
                System.out.println("hello thread, 【匿名内部类Thread】");
            }
        };
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread, 【匿名内部类Runnable】");
            }
        });
        t2.start();

        Thread t3 = new Thread(() ->{
            System.out.println("hello thread, 【lambda表达式】");
        });

    }
}
