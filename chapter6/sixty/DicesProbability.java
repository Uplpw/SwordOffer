package com.java.offer.chapter6.sixty;

import java.util.Arrays;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：n个骰子的点数
 */
public class DicesProbability {
    public static double[] dicesProbability(int n) {
        if (n <= 0) {
            return new double[0];
        }
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public static void main(String[] args) {
        int sum = (1 + 72) * 72 / 2;
        System.out.println(sum);
    }
}
