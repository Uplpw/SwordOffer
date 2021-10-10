package com.java.offer.chapter6.fiftyeight;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：翻转单词顺序
 */
public class ReverseWordsInSentence {
    // 解法1：分割字符串
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 删除首尾单词
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].length() != 0) {
                sb.append(strs[i] + " ");
            }
        }
        return sb.toString().trim();
    }

    // 解法2：双指针
    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        String s = reverseWords(" the sky is blue ");
        System.out.println(s);
    }
}
