package com.java.offer.chapter5.fortysix;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：把数字翻译成字符串
 */
public class TranslateNumbersToStrings {
    // 解法1：递归
    public static int translateNum(int num) {
        if (num < 0) {
            return -1;
        }
        return f(num);
    }

    public static int f(int num) {
        if (num < 10) {
            return 1;
        }
        // 当相邻两位数字在10-25才能被翻译，其他都不行
        if (num % 100 > 9 && num % 100 < 26) {
            return f(num / 10) + f(num / 100);
        } else {
            return f(num / 10);
        }
    }

    // 解法2：动态规划
    public static int translateNumDp(int num) {
        if (num < 0) {
            return -1;
        }
        char[] ch = String.valueOf(num).toCharArray();
        int length = ch.length;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if (n > 9 && n < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
        System.out.println(translateNumDp(12258));

    }
}
