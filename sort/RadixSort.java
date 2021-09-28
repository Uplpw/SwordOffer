package com.java.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/25 19:07
 * @Description
 */
public class RadixSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 先算出最大数
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 再计算最大数的位数
        int count = 0;
        while (max > 0) {
            max /= 10;
            count++;
        }

        // 一共 0~9 10个数字，需要10个list存储
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<>());

        int mod = 10, div = 1;
        // 循环数字的每一位
        for (int i = 0; i < count; i++, mod *= 10, div *= 10) {
            // 循环待排序数组中的每个元素， 将每个位对应的值加入到相应的list
            for (int j = 0; j < nums.length; j++) {
                // 得到元素位对应的值num，从而放到num对应的list
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            int index = 0;
            // 排序
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    nums[index++] = bucketList.get(j).get(k);
                // 注意清空，防止下次继续添加元素
                bucketList.get(j).clear();
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 6, 7, 9, 1};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums = {8, 7, 6, 5, 4, 3, 2, 1};
//        int[] nums = {8};
        System.out.println("排序前：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sort(nums);
        System.out.println("排序后：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
