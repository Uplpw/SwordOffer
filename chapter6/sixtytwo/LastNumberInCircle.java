package com.java.offer.chapter6.sixtytwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：圆圈中最后剩下的数字
 */
public class LastNumberInCircle {
    // 采用模拟法 O(n^2)
    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        // 添加数字到列表（使用链表模拟环）
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 第一次环开始的索引位置
        int start = 0;
        while (n > 1) {
            // 找到要删除的元素位置 (m-1)%n 因为m可能比n大，所以取余操作
            start = (start + m - 1) % n;
            // 移除元素
            list.remove(start);
            // 元素数量减1
            n--;
        }
        return list.get(0);
    }

    // 数学解法
    public static int lastRemaining1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
