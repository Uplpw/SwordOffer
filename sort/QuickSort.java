package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/25 12:47
 * @Description 快速排序
 */
public class QuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            // 从右向左找一个比“哨兵”小的值
            while (low < high && nums[high] >= pivot) --high;
            nums[low] = nums[high];

            // 从左向右找一个比“哨兵”大的值
            while (low < high && nums[low] <= pivot) ++low;
            nums[high] = nums[low];
        }
        // 改变“哨兵”的位置
        nums[low] = pivot;
        // 返回“哨兵”的位置
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 2, 6, 7, 9, 1};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums = {8, 7, 6, 5, 4, 3, 2, 1};
//        int[] nums = {8};
        System.out.println("排序前：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        sort(nums);
        System.out.println("排序后：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
