package com.java.offer.chapter4.thirtyfive;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer
 */
public class ComplexListNode {
    int val;
    ComplexListNode next;
    ComplexListNode random;

    public ComplexListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ComplexListNode cur = this;
        while (cur != null) {
            ret.append(cur.val);
            if (cur.random != null)
                ret.append("(" + cur.random.val + ")");
            else {
                ret.append("(_)");
            }
            ret.append('\t');
            cur = cur.next;
        }
        return ret.toString();
    }
}
