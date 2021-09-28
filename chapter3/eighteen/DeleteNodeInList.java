package com.java.offer.chapter3.eighteen;

public class DeleteNodeInList {
    public static ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return null;
        } else if (head.val == node.val) {
            head = head.next;
            return head;
        } else if (node.next == null) {
            ListNode temp = head;
            while (temp.next.val != node.val) {
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }else {
            node.val=node.next.val;
            node.next=node.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head, node3);
        System.out.println(head);
        head = deleteNode(head, head);
        System.out.println(head);
    }
}
