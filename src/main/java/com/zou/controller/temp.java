package com.zou.controller;

import java.util.HashMap;
import java.util.Map;

public class temp {

    private String age;

    private String name;

    private String address;
    
     private String address8;

    public static void main(String[] args) {
        /*Integer []arr = {5,6,20,88,71,101,1, 120};

        int temp;

        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length -1; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        List<Integer> i2 = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(i2);

        List<Integer> i3 = Arrays.stream(sort(arr)).collect(Collectors.toList());
        System.out.println(i3);*/


        qc();

    }


    public static Integer[] sort(Integer[] array) {

        int temp = 0;
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] > array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    // 数组内数据，找出不重复的数字
    public static void qc(){
        int[] arr = new int[]{1, 2, 4, 1, 2, 5, 7, 8, 5};
        Map<Integer, Boolean> map = new HashMap<>(10);
        for (int i : arr) {
            map.put(i, map.containsKey(i));
        }
        map.forEach((k, v) -> {
            if(v.equals(false)){
                System.out.println(k);
            }
        });
    }

}
