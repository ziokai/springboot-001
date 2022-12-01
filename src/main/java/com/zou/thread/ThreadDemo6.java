package com.zou.thread;

import java.util.concurrent.*;

/**
 * @author zou
 * @data 20222022/12/121:50
 *
 * 线程池创建
 * 线程池参数
 *
 * public ThreadPoolExecutor(
 *        int corePoolSize,       // 核心线程数。
 *        int maximumPoolSize,    // 最大线程数。
 *        long keepAliveTime,     // 空闲线程存活时间。
 *        TimeUnit unit,          // 时间单位
 *        BlockingQueue<Runnable> workQueue, // 线程池任务队列。
 *        ThreadFactory threadFactory,       // 创建线程的工厂。
 *        RejectedExecutionHandler handler   // 拒绝策略。
 * )
 *
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory());

    }
}
