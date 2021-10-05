package com.java.offer.chapter2.fourteen;

import java.lang.Math;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：剪绳子
 */
public class CuttingRope {
    // 动态规划解法
    public static int maxCutting(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        int temp = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                temp = dp[j] * dp[i - j];
                if (temp > max)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // 贪婪算法解法
    public static int maxCuttingByGreedy(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int dot = -1;
        int count = n / 3;
        int m = n % 3;
        if (m == 1) {
            count = count - 1;
            dot = (int) (Math.pow(3, count)) * 4;
        } else if (m == 2) {
            dot = (int) (Math.pow(3, count)) * 2;
        } else {
            dot = (int) (Math.pow(3, count));
        }
        return dot;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println("1:长度为" + i + "的最大值->" + maxCutting(i));
            System.out.println("2:长度为" + i + "的最大值->" + maxCuttingByGreedy(i));
        }
    }
}
