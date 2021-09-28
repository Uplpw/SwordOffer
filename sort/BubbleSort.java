package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/24 21:25
 * @Description 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // 注意内层循环结束条件，因为外层循环每进行一次，数组末尾会增加一个已经排好序的元素（最大，次大，...）
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
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
