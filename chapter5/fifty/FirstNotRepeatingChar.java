package com.java.offer.chapter5.fifty;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {
    // 解法2：利用哈希，遍历两次字符串
    public static char firstUniqChar(String s) {
        char c = ' ';
        if (s == null || s.length() == 0) {
            return c;
        }
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 更新出现次数
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        // 再次访问字符串，找出第一次出现的字符
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                c = s.charAt(i);
                break;
            }
        }
        return c;
    }

    // // 解法3：优化（在长字符串下效率高）同样适合字符流统计第一次出现的字符
    public static char firstUniqChar2(String s) {
        char c = ' ';
        if (s == null || s.length() == 0) {
            return c;
        }
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 更新哈希value
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        Iterator<Map.Entry<Character, Integer>> entries = map.entrySet().iterator();
        int first = length;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer value = (Integer) entry.getValue();
            if (value != -1 && value < first) {
                first = value;
            }
        }
        return first == length ? ' ' : s.charAt(first);
    }

    // 优化 根据题目，只有小写字母26个数字
    public static char firstUniqChar1(String s) {
        char c = ' ';
        if (s == null || s.length() == 0) {
            return c;
        }
        int[] map = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                c = s.charAt(i);
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
        System.out.println(firstUniqChar1("abaccdeff"));
        System.out.println(firstUniqChar2("abaccdeff"));
//        System.out.println(firstUniqChar("abaccdeff"));
    }
}
