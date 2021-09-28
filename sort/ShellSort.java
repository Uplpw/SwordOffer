package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/25 11:05
 * @Description 希尔排序
 */
public class ShellSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        // 增量开始
        int gap = length >> 1;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                // 记录该分组最后一个元素作为待排序元素
                int temp = nums[i];
                // 寻找该分组前一个元素
                int preIndex = i - gap;
                // 插入排序
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    // 前一个元素大于后一个元素，则进行交换（元素后移）
                    nums[preIndex + gap] = nums[preIndex];
                    // 继续寻找该分组前一个元素
                    preIndex -= gap;
                }
                // 将待排序元素插入
                nums[preIndex + gap] = temp;
            }
            // 缩小增量
            gap >>= 1;
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
