package com.zou.thread;

/**
 * @author zou
 * @data 20222022/11/3011:14
 *
 * Runnable 的方式实现多线程
 */
public class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        System.out.println("hello thread, 【implements Runnable】");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadDemo2());
        t.start();
    }

}
