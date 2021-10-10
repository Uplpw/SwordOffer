package com.java.offer.chapter6.fiftythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：有序数组数字出现的次数
 */
public class NumberOfTarget {
    // 解法1：暴力求解
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                count++;
            }
            if (nums[i] > target) {
                break;
            }
        }
        return count;
    }

    // 解法2：二分第一种方式
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int index = getIndex(nums, target);
        if (index == -1) {
            return count;
        } else {
            count++;
            int left = index - 1;
            int right = index + 1;
            while (left >= 0) {
                if (nums[left] == target) {
                    count++;
                    left--;
                } else {
                    break;
                }
            }
            while (right <= nums.length - 1) {
                if (nums[right] == target) {
                    count++;
                    right++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int index = -1;
        // 注意结束条件
        while (left <= right) {
            // mid =  (left + right) / 2 可能出现向上溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return index;
    }

    // 解法2：二分第二种方式，右边界-左边界
    public static int search2(int[] nums, int target) {
        return search2Core(nums, target) - search2Core(nums, target - 1);
    }

    public static int search2Core(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            // 注意溢出
            int m = i + (j - i) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] nums1 = {1};
        System.out.println(search(nums, 8));
        System.out.println(search1(nums, 8));
        System.out.println(search2(nums, 8));
    }
}
