package com.java.offer.chapter5.fortyeight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：最长不含重复字符的子字符串
 */
public class LongestSubstringWithoutDup {
    // 解法1：动态规划
    public static int lengthOfLongestSubstringByDp(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    // 解法2：双指针
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = -1;

        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("abcdefaaa"));
    }
}
