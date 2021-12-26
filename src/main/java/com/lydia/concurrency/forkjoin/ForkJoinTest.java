package com.lydia.concurrency.forkjoin;

import java.util.Random;

public class ForkJoinTest {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        fillArr(arr);

        MyForkJoin myForkJoin = new MyForkJoin(arr, 0, arr.length);
        long startTime = System.currentTimeMillis();
        Long compute = myForkJoin.compute();
        System.out.println("计算结果：" + compute);
        long endTime = System.currentTimeMillis();
        System.out.println("时间：" + (endTime - startTime));
    }

    private static void fillArr(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
    }


}
