package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/25 10:23
 * @Description 归并排序
 */
public class MergeSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 数组长度小于 2 直接返回
        if (nums.length < 2) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        // 递归结束条件
        if (left >= right) return;
        // 找出中间索引，注意不要写成（right + left）/2，可能会发生溢出
        int mid = left + (right - left) / 2;
        // 对左边子序列进行归并排序（递归）
        mergeSort(nums, left, mid);
        // 对右边子序列进行归并排序（递归）
        mergeSort(nums, mid + 1, right);
        // 合并左右子序列
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        // 合并后的数组（注意数组大小设置）
        int[] mergeArray = new int[right - left + 1];

        // 左边子序列的第一个元素索引
        int leftIndex = left;
        // 右边子序列的第一个元素索引
        int rightIndex = mid + 1;

        // 合并后数组的索引
        int index = 0;

        while (leftIndex <= mid && rightIndex <= right) {
            //从两个数组中取出最小的放入临时数组
            if (nums[leftIndex] <= nums[rightIndex]) {
                mergeArray[index++] = nums[leftIndex++];
            } else {
                mergeArray[index++] = nums[rightIndex++];
            }
        }

        // 把 左边子序列或者右边子序列 剩余元素移进合并后的数组（最多只会执行一个循环）
        while (leftIndex <= mid) {
            mergeArray[index++] = nums[leftIndex++];
        }
        while (rightIndex <= right) {
            mergeArray[index++] = nums[rightIndex++];
        }

        // 将合并后的数组元素拷贝到原数组中
        for (int i = 0; i < mergeArray.length; i++) {
            nums[i + left] = mergeArray[i];
        }
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
