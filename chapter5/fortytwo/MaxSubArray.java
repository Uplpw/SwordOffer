package com.java.offer.chapter5.fortytwo;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：连续子数组的最大和
 */
public class MaxSubArray {
    // 1. 动态规划（优化）
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    // 2. 动态规划（不优化）
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] f = new int[length];
        f[0] = nums[0];
        int result = f[0];
        for (int i = 1; i < length; i++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
            if (result < f[i]) {
                result = f[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSubArray(a));
        System.out.println(maxSubArray1(a));
    }
}
