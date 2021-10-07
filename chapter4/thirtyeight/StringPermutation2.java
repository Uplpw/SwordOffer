package com.java.offer.chapter4.thirtyeight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/28 16:14
 * @Description 剑指offer：字符串的排列
 */
public class StringPermutation2 {
    static List<String> res = new ArrayList<>();
    static char[] c;

    public static String[] permutation(String s) {
        c = s.toCharArray();
        permutationCore(0);
        return res.toArray(new String[res.size()]);
    }

    public static void permutationCore(int x) {
        // 固定到最后一位字符，将其添加排列方案
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(i, x);
            // 开启固定第 x + 1 位字符
            permutationCore(x + 1);
            // 恢复交换，防止影响后面的结果
            swap(i, x);
        }
    }

    public static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
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
