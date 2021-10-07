package com.java.offer.chapter3.twentyfive;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
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
