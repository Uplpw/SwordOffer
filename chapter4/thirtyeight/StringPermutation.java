package com.java.offer.chapter4.thirtyeight;

import java.util.*;

public class StringPermutation {
    public static String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return null;
        List<String> list = new ArrayList<>();
        permutationCore(s, list, 0);
        return list.toArray(new String[list.size()]);
    }


    public static void permutationCore(String s, List<String> list, int index) {
        // 索引到最后一位字符，交换结束，添加到结果中
        if (index == s.length()) {
            list.add(s);
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < s.length(); i++) {
            char[] array = s.toCharArray();
            // 集合有相同元素不再添加，并且不再交换，直接跳过，开始下一个字符
            if (set.add(array[i])) {
                // 当前字符逐渐与后面字符进行交换
                swap(array, index, i);
                // 当前字符索引往后走一位，由于new创建新的字符串，所以不需要再次交换防止影响后面的结果
                permutationCore(new String(array), list, index + 1);
            }
        }
    }

    public static void swap(char[] strs, int x, int y) {
        char temp = strs[x];
        strs[x] = strs[y];
        strs[y] = temp;
    }

    public static void main(String[] args) {
        String s = "aabb";
        String[] array = permutation(s);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }
}
