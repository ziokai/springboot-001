package com.zou.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zou
 * @data 20222022/11/3020:21
 *
 * 线程池的方式实现多线程
 * 实际企业中应用的场景，当调用多个远程接口的时候，以节省时间
 */
public class ThreadDemo5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建一个线程池为4
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            // 创建一个线程集合
            ArrayList<Callable<String>> callableList = new ArrayList<>();

            // 调用第1个RPC接口，模拟接口请求时间
            Callable<String> callableA = () -> { Thread.sleep(100); return "A"; };
            callableList.add(callableA);

            // 调用第2个RPC接口
            Callable<String> callableB = () -> { Thread.sleep(120); return "B"; };
            callableList.add(callableB);

            // 调用第3个RPC接口
            Callable<String> callableC = () -> { Thread.sleep(200); return "C"; };
            callableList.add(callableC);

            // 调用第4个RPC接口
            Callable<String> callableD = () -> { Thread.sleep(150); return "D"; };
            callableList.add(callableD);

            // 执行所有线程
            List<Future<String>> futuresList = executorService.invokeAll(callableList);

            // 将所有线程结果存入到stringBuilder
            StringBuilder stringBuilder = new StringBuilder();
            for (Future<String> list : futuresList) {
                stringBuilder.append(list.get());
            }
            long endTime = System.currentTimeMillis();
            System.out.println("四个接口调用完毕，返回结果：" + stringBuilder.toString() + "，总耗时：" + (endTime - startTime) + "毫秒");

        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorService.shutdown();
        }

    }
}
