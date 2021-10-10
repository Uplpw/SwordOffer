package com.java.offer.chapter6.sixtyfive;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：不用加减乘除做加法
 */
public class AddTwoNumbers {
    public static int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(-4, 1));
    }
}
