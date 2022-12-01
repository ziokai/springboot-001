package com.zou.thread;

/**
 * @author zou
 * @data 20222022/11/3011:14
 *
 * Thread 的方式实现多线程
 */
public class ThreadDemo1 extends Thread{

    @Override
    public void run() {
        System.out.println("hello thread, 【extends Thread】");
    }

    public static void main(String[] args) {
        Thread thread = new ThreadDemo1();
        thread.start();
    }
}
