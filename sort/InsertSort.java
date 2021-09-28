package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/24 22:08
 * @Description 插入排序
 */
public class InsertSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 第一个元素默认已经排序好
        for (int i = 1; i < nums.length; i++) {
            // 当前待排序元素
            int current = nums[i];
            // 对前面排序好的元素列从末尾扫描
            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                // 往后移动
                nums[j + 1] = nums[j];
                // 索引前移
                j--;
            }
            // 将当前元素插入
            nums[j + 1] = current;
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
