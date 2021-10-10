package com.java.offer.chapter5.forty;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：最小的k个数
 */
public class KLeastNumbers {
    // 解法1：排序，取前面k个元素
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = arr[i];
        }
        return array;
    }

    // 解法2：利用快排分区
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return new int[0];
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    public static int[] quickSort(int[] arr, int k, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) j--;
            while (i < j && arr[i] <= arr[left]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);
        // 当左边元素个数大于k，左边界不变，右边界缩小
        if (i > k - 1) {
            return quickSort(arr, k, left, i - 1);
        }
        // 当左边元素个数小于k，右边界不变，左边界增大
        if (i < k - 1) {
            return quickSort(arr, k, i + 1, right);
        }
        // 当左边元素等于k时，返回一个数组，等于数组arr的前k个元素
        return Arrays.copyOf(arr, k);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 解法3：最大堆
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (arr == null || k <= 0 || arr.length < k) {
            return null;
        }
        int[] vec = new int[k];
        // 维护一个大小为k的顺序堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
