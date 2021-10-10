package com.java.offer.chapter6.fiftythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：有序数组中的缺失数字
 */
public class GetMissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        // 注意初始化，缺失的可能是 n
        int index = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != i) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 二分求解
    public static int missingNumber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            // 注意加减法优先级高于位运算
            int mid = left + ((right - left) >> 1);
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{0, 1, 2, 3, 4, 5}; //6
        int[] data2 = new int[]{0, 1, 3, 4, 5}; //2
        int[] data3 = new int[]{1, 2}; //0
//        System.out.println(missingNumber(data1));
//        System.out.println(missingNumber(data2));
//        System.out.println(missingNumber(data3));
        System.out.println(missingNumber2(data1));
        System.out.println(missingNumber2(data2));
        System.out.println(missingNumber2(data3));
    }
}
