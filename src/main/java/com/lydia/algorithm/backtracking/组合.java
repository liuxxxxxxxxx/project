package com.lydia.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 组合 {

    public static void main(String[] args) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        backTracking(path, res, 4, 2, 1);
        System.out.println(res);

    }


    /**
     * 给定一个n,k,取出[1...n]数量为k的数组，
     * 4,2
     * [1,2,3,4]
     *          取1          取2          取3          取4
     * 取2  取3  取4      取3  取4      取4            null
     * [1,2][1,3][1,4]   [2,3][2,4]    [3,4]
     */
    private static void backTracking(Deque<Integer> path, List<List<Integer>> res, int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            backTracking(path, res, n, k, i+1);
            path.removeLast();
        }

    }
}
