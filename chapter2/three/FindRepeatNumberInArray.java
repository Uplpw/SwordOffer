package com.java.offer.chapter2.three;

import java.util.Arrays;

/**
 * @Author lpw
 * @Date 2021/9/22 16:34
 * @Description 剑指offer：数组中重复的数字
 */
public class FindRepeatNumberInArray {

    // 解法1：暴力求解
    public static int findRepeatNumber1(int[] nums) {
        boolean result = illegalJudgment(nums);
        if (result == false) return -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 解法2：快排
    public static int findRepeatNumber2(int[] nums) {
        boolean result = illegalJudgment(nums);
        if (result == false) return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // 解法3：哈希表（数组代替）
    public static int findRepeatNumber3(int[] nums) {
        boolean result = illegalJudgment(nums);
        if (result == false) return -1;
        int[] hash = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] >= 1) {
                return nums[i];
            } else {
                hash[nums[i]]++;
            }
        }
        return -1;
    }

    // 解法4：
    public static int findRepeatNumber4(int[] nums) {
        boolean result = illegalJudgment(nums);
        if (result == false) return -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static boolean illegalJudgment(int[] nums) {
        // 空指针以及没有元素
        if (nums == null && nums.length <= 0) {
            return false;
        }
        // 数组元素不在 0 到 n-1 范围内
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && nums[i] > nums.length - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 2, 1, 5, 6};
        System.out.println(findRepeatNumber1(nums));
        System.out.println(findRepeatNumber2(nums));
        System.out.println(findRepeatNumber3(nums));
        System.out.println(findRepeatNumber4(nums));
    }
}
