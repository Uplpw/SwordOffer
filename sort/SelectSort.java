package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/24 21:52
 * @Description 选择排序
 */
public class SelectSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录最小元素的索引位置
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 与最小元素比较
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            // 找到最小元素并进行交换
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
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
