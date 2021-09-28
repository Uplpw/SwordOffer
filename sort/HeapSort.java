package com.java.sort;

/**
 * @Author lpw
 * @Date 2021/9/25 13:53
 * @Description 堆排序
 */
public class HeapSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 新建一个最大堆
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i >= 1; i--) {
            // 堆顶元素与最后元素交换
            swap(nums, 0, i);
            // 调整最大堆
            adjustMaxHeap(nums, 0, i - 1);
        }
    }

    public static void buildMaxHeap(int[] nums) {
        // 从子节点到根节点构建最大堆，注意父节点与子节点的索引关系（因为是之间利用数组代替，所以child=parent*2, child=parent*2+1）
        for (int i = 1; i < nums.length; i++) {
            int parent = (i - 1) >> 1;
            int child = i;
            // 当有孩子节点以及孩子节点比父节点大，则进行交换
            while (child > 0 && nums[parent] < nums[child]) {
                swap(nums, parent, child);
                // 交换后，父节点值变化，则需要判断父节点与父节点的父节点之间的关系，为了利用循环实现这个逻辑，更新孩子与父节点的索引
                // 孩子节点索引更新为父节点索引
                child = parent;
                // 父节点索引更新为父节点的父节点索引
                parent = (parent - 1) >> 1;
            }
        }
    }

    public static void adjustMaxHeap(int[] nums, int parent, int last) {
        // 根节点值变化，则需要从根节点更新大顶堆
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int maxIndex = left;
        // 找到最大子节点，注意索引不能超过最后的索引（即判断父节点有没有子节点）
        if (right <= last && nums[right] > nums[left]) {
            maxIndex = right;
        }
        // 和最大子节点比较
        if (left <= last && nums[parent] < nums[maxIndex]) {
            // 互换到最大子节点
            swap(nums, parent, maxIndex);
            // 自上而下递归更新大顶堆
            adjustMaxHeap(nums, maxIndex, last);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
