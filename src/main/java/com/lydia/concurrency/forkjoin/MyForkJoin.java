package com.lydia.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyForkJoin extends RecursiveTask<Long> {
    // 任务拆分最小阈值
    static final int SEQUENTIAL_THRESHOLD = 10000;

    int low;
    int high;
    int[] array;

    MyForkJoin(int[] arr, int lo, int hi) {
        array = arr;
        low = lo;
        high = hi;
    }

    @Override
    protected Long compute() {
        //当任务拆分到小于等于阀值时开始求和
        if (high - low <= SEQUENTIAL_THRESHOLD) {

            long sum = 0;
            for (int i = low; i < high; ++i) {
                sum += array[i];
            }
            return sum;
        } else {  // 任务过大继续拆分
            int mid = low + (high - low) / 2;
            MyForkJoin left = new MyForkJoin(array, low, mid);
            MyForkJoin right = new MyForkJoin(array, mid, high);
            // 提交任务
            left.fork();
            right.fork();
            //获取任务的执行结果,将阻塞当前线程直到对应的子任务完成运行并返回结果
            long rightAns = right.join();
            long leftAns = left.join();
            return leftAns + rightAns;
        }
    }

}
