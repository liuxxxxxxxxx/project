package com.lydia.algorithm.doublepointer;

import com.lydia.algorithm.doublepointer.common.ListNode;

public class 反转链表 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode solution = solution(node1);

        System.out.println(solution);

    }

    /**
     * 题意：反转一个单链表。
     * <p>
     * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
     * <p>
     * <p>
     * 定义一个指针cur，指向表头节点，定义一个pre初始化为null
     * 用tmp记录cur.next,cur.next=pre,循环
     */
    private static ListNode solution(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
