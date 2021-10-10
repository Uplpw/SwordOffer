package com.java.offer.chapter6.fiftysix;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：数组出现一次的数字，其他数字出现三次
 */
public class NumberAppearOneInThree {
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = 0;
        int length = nums.length;
        int[] bit = new int[32];
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            for (int j = 31; j >= 0; j--) {
                if ((temp & 1) == 1) {
                    bit[j] += 1;
                }
                temp = temp >>> 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            result = result + (int) ((bit[i] % 3) * Math.pow(2, (31 - i)));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 1, 1, 2, 3, 2, 2};
        System.out.println(singleNumber(data));
    }
}
