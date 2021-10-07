package com.java.offer.chapter3.eighteen;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
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
        ret.append("[");
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
                ret.deleteCharAt(ret.lastIndexOf(" "));
                ret.deleteCharAt(ret.lastIndexOf(","));
                break;
            }
            ret.append(cur.val);
            ret.append(", ");
        }
        ret.append("]");
        return ret.toString();
    }
}
