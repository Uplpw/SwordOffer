package com.java.offer.chapter5.fortynine;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：丑数
 */
public class Ugly {
    // 解法1：遍历
    public static int getUglyNumber(int num) {
        if (num <= 0)
            return 0;
        if (num == 1) {
            return 1;
        }
        int ugly = 0;
        int count = 1;
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i)) {
                count++;
                if (count == num) {
                    ugly = i;
                    break;
                }
            }
//            if (isUgly1(i)) {
//                count++;
//                if (count == num) {
//                    ugly = i;
//                    break;
//                }
//            }
        }
        return ugly;
    }

    public static boolean isUgly(int num) {
        while (true) {
            if (num % 2 == 0) {
                num /= 2;
                if (num == 1) {
                    return true;
                }
            } else if (num % 3 == 0) {
                num /= 3;
                if (num == 1) {
                    return true;
                }
            } else if (num % 5 == 0) {
                num /= 5;
                if (num == 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean isUgly1(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    // 解法2：直接计算丑数
    public static int getUglyNumber1(int num) {
        if (num <= 0)
            return 0;
        int[] dp = new int[num];
        // 第一个丑数
        dp[0] = 1;
        // 分别计算当前丑数有多少个2，3，5相乘组成
        int mul2 = 0;
        int mul3 = 0;
        int mul5 = 0;
        for (int i = 1; i < num; i++) {
            // 计算前面三个丑数乘以2，3，5后哪个最小。
            dp[i] = min(dp[mul2] * 2, dp[mul3] * 3, dp[mul5] * 5);
            // 2*3=6，3*2=6，会有重复值
            if (dp[mul2] * 2 == dp[i]) {
                mul2++;
            }
            if (dp[mul3] * 3 == dp[i]) {
                mul3++;
            }
            if (dp[mul5] * 5 == dp[i]) {
                mul5++;
            }
        }
        return dp[num - 1];
    }

    public static int min(int a, int b, int c) {
        int x = a > b ? b : a;
        return x > c ? c : x;
    }

    public static void main(String[] args) {
        int num = 1352;
        System.out.println(getUglyNumber(num));
        // 402653184
        // 402653184
//        System.out.println(getUglyNumber1(num));
    }
}
