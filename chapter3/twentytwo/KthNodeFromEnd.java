package com.java.offer.chapter3.twentytwo;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：链表中倒数第k个节点
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
