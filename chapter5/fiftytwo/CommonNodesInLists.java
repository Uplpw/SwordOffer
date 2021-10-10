package com.java.offer.chapter5.fiftytwo;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：两个链表的第一个公共节点
 */
public class CommonNodesInLists {
    // 解法2：使用两个栈实现，不断出栈完成
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        while (node1 != null) {
            stack1.push(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            stack2.push(node2);
            node2 = node2.next;
        }
        ListNode node = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                node = stack1.peek();
                stack1.pop();
                stack2.pop();
            } else break;
        }
        return node;
    }

    // 解法3：删除长链表的前面节点使得其与链表相等，然后两个链表同时往下走进行判断
    public static ListNode getIntersectionNodeByCount(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        int count1 = 0;
        int count2 = 0;
        while (node1 != null) {
            count1++;
            node1 = node1.next;
        }
        while (node2 != null) {
            count2++;
            node2 = node2.next;
        }
        node1 = headA;
        node2 = headB;
        if (count1 > count2) {
            int subtract = count1 - count2;
            for (int i = 0; i < subtract; i++) {
                node1 = node1.next;
            }
        } else if (count1 < count2) {
            int subtract = count2 - count1;
            for (int i = 0; i < subtract; i++) {
                node2 = node2.next;
            }
        }
        ListNode node = null;
        while (node1 != null) {
            if (node1 == node2) {
                node = node1;
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node;
    }

    // 解法4：双指针
    public static ListNode getIntersectionNodeByTwoPoint(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        // 1->2->3->6->7
        //    4->5↗
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        // head1
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;

        // head2
        node4.next = node5;
        node5.next = node6;

        // common
        node6.next = node7;

        System.out.println(getIntersectionNode(node1, node4).val);
        System.out.println(getIntersectionNodeByCount(node1, node4).val);
        System.out.println(getIntersectionNodeByTwoPoint(node1, node4).val);
    }
}
