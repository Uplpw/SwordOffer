package com.java.offer.chapter3.twentyfour;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode pCurrent = head;
        ListNode pNext = pCurrent.next;
        while (pNext != null) {
            if (preNode == null) {
                pCurrent.next = null;
            } else {
                pCurrent.next = preNode;
            }
            preNode = pCurrent;
            pCurrent = pNext;
            pNext = pNext.next;
        }
        // 最后一个节点注意要连上前面的节点
        pCurrent.next = preNode;
        return pCurrent;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(head);
        System.out.println(reverseList(head));
    }
}
