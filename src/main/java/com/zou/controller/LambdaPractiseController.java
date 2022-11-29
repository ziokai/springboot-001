package com.zou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * @author zou
 * @data 20222022/11/722:23
 */
public class LambdaPractiseController {
    public static void main(String[] args) {

        // LambdaList();

        // 创建多线程
        Thread rrr = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程中run方法被执行了");
            }
        });
        rrr.start();

        // 使用lambda创建多线程
        new Thread(() -> {System.out.println("多线程中run方法以lambda方式被执行了");}).start();

        // --- Lambda抽取练习 1 ------------------------------------------------------------
        // --- 只关注参数，和方法体 ------------------------------------------------------------
        // 使用传统方法
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });

        // 使用lambda创建匿名内部类
        int i2 = calculateNum((int left, int right) -> {
            return left + right;
        });

        // --- Lambda抽取练习 2 ------------------------------------------------------------
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value%2==0;
            }
        });

        printNum((int value) -> {
            return value%2==0;
        });


        // --- Lambda抽取练习 3 ------------------------------------------------------------

    }

    public static void printNum(IntPredicate predicate){
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        for (int i : arr){
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }

    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }


    // for循环
    private static void LambdaList() {
        // 声明一个集合
        String[] array = new String[]{"1","2", "3", "4"};
        List<String> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();

        int tt = 0;
        for (String s : array) {
            list.add(s);
            map.put(tt, s);
            tt++;
        }
        tt = 0;

        // for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // foreach
        for (String s : list) {
            System.out.println(s);
        }

        // lambda
        list.forEach(s -> {
            if(s.equals("3")){
                System.out.println("3333");
            }
            System.out.println(s);
        });


        map.forEach((k, v) -> System.out.println("K:" + k + "v:" + v));
    }
}
