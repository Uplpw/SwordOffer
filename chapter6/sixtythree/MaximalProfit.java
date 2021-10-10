package com.java.offer.chapter6.sixtythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：股票的最大利润
 */
public class MaximalProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = prices[0];
        int maxDiff = prices[1] - min;
        if (prices[1] < min)
            min = prices[1];
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] - min > maxDiff)
                maxDiff = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
        }
        // 注意最后判断最大值是否小于等于0（数组递减情况）
        return maxDiff <= 0 ? 0 : maxDiff;
    }
}
