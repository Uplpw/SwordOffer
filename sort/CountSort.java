package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/25 17:28
 * @Description 计数排序
 */
public class CountSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 找出数组最大、最小元素
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        // 统计每个元素出现次数并存入数据第 i 项
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i] - min]++;
        }

        // 统计数组做变形，后边的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 倒序遍历原始数组，从统计数组中找到正确的位置，输出到结果数组
        int[] sortedArray = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            // 给sortedArray的当前位置赋值
            // countArray[nums[i] - min] - 1 代表有多少个元素小于 nums[i] 值，所以把 nums[i]放在第 countArray[nums[i] - min]-1 位
            sortedArray[countArray[nums[i] - min] - 1] = nums[i];
            // 给 countArray 的位置的值-1
            countArray[nums[i] - min]--;
        }

        // 最后填充到原数组中，
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sortedArray[i];
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
