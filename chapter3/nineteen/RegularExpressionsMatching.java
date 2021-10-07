package com.java.offer.chapter3.nineteen;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：正则表达式匹配
 */
public class RegularExpressionsMatching {
    // 动态规划
    public static boolean isMatchDynamicly(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        // 初始化首行
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                    else if (dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                    else if (dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                    else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(isMatchDynamicly("aaa", "a.a"));//true
        System.out.println(isMatchDynamicly("aaa", "ab*ac*a"));//true
        System.out.println(isMatchDynamicly("aaa", "aa.a"));//false
        System.out.println(isMatchDynamicly("aaa", "ab*a"));//false
    }
}
