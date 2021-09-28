package com.java.offer.chapter3.eighteen;

public class DeleteRepeatNodeInList {
    public static ListNode deleteRepeatNode(ListNode head) {
        if (head == null) {
            return null;
        } else {
            if (head.next == null) {
                return head;
            }
            ListNode pHead = null;
            ListNode pCurrent = head;
            ListNode pNext = pCurrent.next;
            boolean flag = false;

            while (pNext != null) {
                if (pCurrent.val == pNext.val) {
                    flag = true;
                    pNext = pNext.next;
                } else if (flag && pCurrent.val != pNext.val) {
                    if (pHead == null) {
                        head = pNext;
                    } else {
                        pHead.next = pNext;
                    }
                    pCurrent = pNext;
                    pNext = pNext.next;
                    flag = false;
                } else {
                    pHead = pCurrent;
                    pCurrent = pNext;
                    pNext = pNext.next;
                }
            }
            if (flag && pHead != null) {
                pHead.next = null;
            } else if (flag && pHead == null) {
                head = null;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        // 1,2,3,4,5,6,7
        // 1,1,2,2,2,3,3
        // 1,1,1,1,1,1,1
        // 1,2,3,4,5,6,6
        // 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(head);
        head = deleteRepeatNode(head);
        System.out.println(head);
    }
}
