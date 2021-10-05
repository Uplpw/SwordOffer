package com.java.offer.chapter2.ten;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：斐波那契数列
 */
public class Fibonacci {
    // 递归解法，由于重复计算导致效率低，复杂度为O(n^2)
    public static int fibonacciRecursionly(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            return (fibonacciRecursionly(n - 1) + fibonacciRecursionly(n - 2)) % 1000000007;
        }
    }

    // 循环解法，从下往上计算，避免重复计算，复杂度为O(n)
    public static int fibonacciCyclely(int n) {
        int fibonacci = 0;
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            int n_2 = 0;
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
        System.out.println("递归实现");
        System.out.println(fibonacciRecursionly(13));

        System.out.println("循环实现");
        System.out.println(fibonacciCyclely(13));
    }
}
