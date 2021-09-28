package com.java.offer.chapter3.twentytwo;

/*
    题目要求：
    求链表中倒数第k个节点。链表的尾节点定义为倒数第1个节点。

    解题思路：
    如果先求链表的长度，计算后再从头遍历，虽然时间复杂度是o(n),但需要两遍扫描。更好的方式是使用两个距离为k的指针向右移动，这种方式只需扫描一遍。

 */
public class KthNodeFromEnd {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode move = head;
        ListNode pHead = null;
        int count = 0;
        while (move != null) {
            move = move.next;
            count++;
            if (count == k) {
                pHead = head;
            } else if (count > k) {
                pHead = pHead.next;
            }
        }
        if (count < k) {
            return null;
        } else {
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(getKthFromEnd(head, 1));
        System.out.println(getKthFromEnd(head, 2));
//        System.out.println(getKthFromEnd(head,3).val);
//        System.out.println(getKthFromEnd(head,4));
    }
}
