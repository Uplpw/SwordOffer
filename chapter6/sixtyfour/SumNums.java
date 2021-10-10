package com.java.offer.chapter6.sixtyfour;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：求 `1+2+...+n`
 */
public class SumNums {
    // 递归运算
    public static int sumNums(int n) {
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
