package com.java.offer.chapter6.fiftythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：求排序数组数字等于索引
 */
public class IntegerIdenticalToIndex {
    public static int integerIdenticalToIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == i) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int integerIdenticalToIndex2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            // 注意加减法优先级高于位运算
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                left = mid;
                break;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{0, 1, 2, 3, 4, 5}; //0
        int[] data2 = new int[]{-3, -1, 1, 3, 5}; //3
        int[] data3 = new int[]{1, 2}; //-1
        System.out.println(integerIdenticalToIndex(data1));
        System.out.println(integerIdenticalToIndex(data2));
        System.out.println(integerIdenticalToIndex(data3));
        System.out.println(integerIdenticalToIndex2(data1));
        System.out.println(integerIdenticalToIndex2(data2));
        System.out.println(integerIdenticalToIndex2(data3));
    }


}
