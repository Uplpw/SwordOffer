package com.java.offer.chapter2.ten;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：青蛙跳台阶
 */
public class FrogJumping {
    public static int frogJumping(int n) {
        int fibonacci = 0;
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int n_2 = 1;
            int n_1 = 1;
            for (int i = 2; i <= n; i++) {
                int temp = n_2 % 1000000007;
                n_2 = n_1 % 1000000007;
                n_1 = (temp + n_1) % 1000000007;
            }
            fibonacci = n_1;
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        System.out.println(frogJumping(1));
        System.out.println(frogJumping(2));
        System.out.println(frogJumping(3));
    }
}
