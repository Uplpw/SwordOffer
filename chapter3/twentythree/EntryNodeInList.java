package com.java.offer.chapter3.twentythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：链表中环的入口节点
 */
public class EntryNodeInList {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println(detectCycle(head).val);
    }
}
