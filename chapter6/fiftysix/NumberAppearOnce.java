package com.java.offer.chapter6.fiftysix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：数组中只出现一次的两个数字
 */
public class NumberAppearOnce {
    // 解法1：hashmap
    public static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] array = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int index = 0;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 1) {
                array[index++] = entry.getKey();
            }
            if (index >= 2) {
                break;
            }
        }
        return array;
    }

    // 解法2：利用异或
    public static int[] singleNumbers2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int temp = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            temp = temp ^ nums[i];
        }
        int[] result = new int[]{0, 0};
        int index = temp & -temp;
        for (int i = 0; i < length; i++) {
            // 同位不是1
            if ((index & nums[i]) == 0){
                result[0] = result[0] ^ nums[i];
            } else{
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 5, 2};
        int[] result1 = singleNumbers(data);
        int[] result2 = singleNumbers2(data);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + "\t");
        }
        System.out.println();
    }
}
