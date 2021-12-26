package com.lydia.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new LinkedList<>();

        backTracking("aab", path, res, 0);
        System.out.println(res);
    }

    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案。
     *
     * 示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
     *
     *                      aab
     *          截取a         截取a         截取b
     *          a|ab           aa|b         aab|
     *     截取a      截取ab    截取b         return
     *     a|a|b     return     aa|b|
     *      截取b
     *      a|a|b|
     *
     */
    private static void backTracking(String s, Deque<String> path, List<List<String>> res, int startIndex){

        if (startIndex>=s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i<s.length();i++){
            String substring = s.substring(startIndex, i + 1);
            if (isHuiwen(substring)){
                path.addLast(substring);
            }else {
                continue;
            }
            backTracking(s, path, res, i+1);

        }
    }

    private static boolean isHuiwen(String substring) {
        for (int i = 0, j = substring.length() - 1; j >= i; i++, j--){
            if (substring.charAt(i) != substring.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
