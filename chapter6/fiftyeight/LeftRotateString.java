package com.java.offer.chapter6.fiftyeight;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：左转字符串
 */
public class LeftRotateString {
    // 解法1：逐个添加
    public static String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n > s.length()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = n; i < length; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    // 解法2：利用求余运算，优化遍历操作
    public static String reverseLeftWords1(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n > s.length()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int length = s.length();
        for (int i = n; i < n + length; i++)
            res.append(s.charAt(i % length));
        return res.toString();
    }

    // 解法3：切片操作
    public static String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0 || n > s.length()) {
            return "";
        }
        return s.substring(n, s.length()) + s.substring(0, n);
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }
}
