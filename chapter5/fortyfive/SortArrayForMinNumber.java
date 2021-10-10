package com.java.offer.chapter5.fortyfive;

import java.util.Arrays;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：把数组排列成最小的数
 */
public class SortArrayForMinNumber {
    // 解法1：重写排序逻辑
    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    /*
        Lambda表达式的本质只是一个"语法糖",由编译器推断并帮你转换包装为常规的代码,因此你可以使用更少的代码来实现同样的功能。
        // 1. 不需要参数,返回值为 5
        () -> 5

        // 2. 接收一个参数(数字类型),返回其2倍的值
        x -> 2 * x

        // 3. 接受2个参数(数字),并返回他们的差值
        (x, y) -> x – y

        // 4. 接收2个int型整数,返回他们的和
        (int x, int y) -> x + y
     */
    // 解法2：重写内置排序函数
    public static String sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));  // 语法糖
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb = sb.append(strs[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{3, 32, 321}));
        System.out.println(sort(new int[]{3, 32, 321}));
    }
}
