package com.java.offer.chapter3.twentyone;

/*
    调整数组顺序使奇数位于偶数前面
 */
public class ReorderArray {
    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (flag(nums, start, end)) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            } else {
                if ((nums[start] & 1) == 1) {
                    start++;
                }
                if ((nums[end] & 1) == 0) {
                    end--;
                }
            }
        }
        return nums;
    }

    public static boolean flag(int[] nums, int start, int end) {
        // 前面是偶数，后面是奇数，返回true调整顺序
        if ((nums[start] & 1) == 0 && (nums[end] & 1) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 7, 7};
        int[] data = exchange(nums);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
