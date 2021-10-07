package com.java.offer.chapter3.twentyfive;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：合并有序链表
 */
public class MergeSortedList {
    // 循环实现
    public static ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode pHead = null;
        ListNode pNext = pHead;
        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                if (pHead == null) {
                    pHead = current1;
                    pNext = pHead;
                } else {
                    pNext.next = current1;
                    pNext = pNext.next;
                }
                current1 = current1.next;
            } else {
                if (pHead == null) {
                    pHead = current2;
                    pNext = pHead;
                } else {
                    pNext.next = current2;
                    pNext = pNext.next;
                }
                current2 = current2.next;
            }
        }
        if (current1 != null) {
            pNext.next = current1;
        }
        if (current2 != null) {
            pNext.next = current2;
        }

        return pHead;
    }

    //递归实现
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pHead = null;
        if (l1.val <= l2.val) {
            pHead = l1;
            pHead.next = merge(l1.next, l2);
        } else {
            pHead = l2;
            pHead.next = merge(l1, l2.next);
        }
        return pHead;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        System.out.println(head1);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(6);
        System.out.println(head2);
//        System.out.println(mergeList(head1, head2));
        System.out.println(merge(head1, head2));
    }
}
