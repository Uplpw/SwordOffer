package com.java.offer.chapter4.thirtyfive;

import java.util.HashMap;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：复杂链表的复制
 */
public class ComplexListNodeClone {
    // 解法1：简单解法
    public static ComplexListNode copyRandomList1(ComplexListNode head) {
        if (head == null)
            return null;
        // 新链表的头节点
        ComplexListNode newHead = new ComplexListNode(head.val);
        // 旧链表的当前节点
        ComplexListNode current = head.next;
        // 新链表创建的新节点
        ComplexListNode newCurrent = null;
        // 新链表创建的新节点的上一个节点
        ComplexListNode newCurrentPrev = newHead;

        // 复制旧链表节点值和下一个指针
        while (current != null) {
            // 创建新节点
            newCurrent = new ComplexListNode(current.val);
            // 连接新节点
            newCurrentPrev.next = newCurrent;
            // 指针移向下一个节点
            newCurrentPrev = newCurrentPrev.next;
            // 旧链表指针移向下一个节点
            current = current.next;
        }
        current = head;
        newCurrent = newHead;
        ComplexListNode temp = head;
        ComplexListNode newTemp = newHead;

        // 使用双重循环复制旧链表随机指针
        while (current != null) {
            // 判断随机指针是否为空
            if (current.random != null) {
                temp = head;
                newTemp = newHead;
                while (temp != current.random) {
                    // 新旧指针一起往后移动
                    temp = temp.next;
                    newTemp = newTemp.next;
                }
                newCurrent.random = newTemp;
            }
            // 为下一个节点复制随机指针
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }

    // 解法2：利用hash
    public static ComplexListNode copyRandomList2(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        // 利用hash将新旧链表节点一一对应起来
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        ComplexListNode newHead = new ComplexListNode(head.val);
        map.put(head, newHead);
        ComplexListNode newCurrent = newHead;
        ComplexListNode newNode = null;
        ComplexListNode current = head.next;
        // 先复制旧链表的值和下一个指针
        while (current != null) {
            newNode = new ComplexListNode(current.val);
            map.put(current, newNode);
            newCurrent.next = newNode;
            newCurrent = newCurrent.next;
            current = current.next;
        }
        current = head;
        newCurrent = newHead;
        // 再复制旧链表的随机指针
        while (current != null) {
            if (current.random != null) {
                newCurrent.random = map.get(current.random);
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:" + '\t' + head);
        System.out.println("clone1:  " + '\t' + copyRandomList1(head));
    }
}
