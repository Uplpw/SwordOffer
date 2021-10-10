package com.java.offer.chapter6.fiftyseven;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：和为s的数字
 */
public class SumS {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return new int[2];
        }
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}
