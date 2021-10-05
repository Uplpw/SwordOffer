package com.java.offer.chapter2.six;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：链表结构
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
                break;
            }
            ret.append(cur.val);
            ret.append("\t");
        }
        return ret.toString();
    }
}
