package com.java.offer.chapter6.sixtyone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：扑克牌中的顺子
 */
public class ContinousCards {
    // 解法1
    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if(nums[i] == nums[i + 1]){
                return false;
            }
        }
        return nums[4] - nums[zero] < 5;
    }

    // 解法2
    public boolean isStraight1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static void main(String[] args) {
//        System.out.println(isStraight(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(isStraight(new int[]{0, 0, 1, 2, 5}));
//        System.out.println(isStraight(new int[]{0, 3, 1, 2, 5}));
//        System.out.println(isStraight(new int[]{0, 3, 1, 2, 7}));
        // [9,0,6,0,10]
        System.out.println(isStraight(new int[]{9, 0, 6, 0, 10}));
    }
}
