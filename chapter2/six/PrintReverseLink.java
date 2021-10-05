package com.java.offer.chapter2.six;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/22 16:34
 * @Description 剑指offer：从尾到头打印链表
 */
public class PrintReverseLink {
    // 解法1：递归实现
    public static int[] printReversingly1(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        printReversinglyCore1(head, list);
        int length = list.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void printReversinglyCore1(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        printReversinglyCore1(node.next, list);
        list.add(node.val);
    }

    // 解法2：非递归，使用辅助栈
    public static int[] printReversingly2(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }
        int length = stack.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(head);
        int[] result1 = printReversingly1(head);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + "\t");
        }
        System.out.println();
        int[] result2 = printReversingly2(head);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + "\t");
        }
        System.out.println();
    }
}
