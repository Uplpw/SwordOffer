package com.java.offer.chapter5.thirtynine;

import java.util.Arrays;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：数组中出现次数超过一半的数字
 */
public class MoreThanHalfNumber {
    // 解法1：排序后找中位数
    public static int majorityElement(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 解法2：根据数字特点
    public static int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value)
                count++;
            else if (nums[i] != value && count == 1)
                value = nums[i];
            else
                count--;
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
