package com.java.offer.chapter6.fiftynine;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：滑动窗口的最大值
 */
public class MaxInSlidingWindow {
    // 解法1：暴力求解
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k || k <= 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int length = nums.length;
        int len = length - k + 1;
        int[] array = new int[len];
        array[0] = nums[0];
        for (int j = 0; j < k; j++) {
            array[0] = (array[0] < nums[j]) ? nums[j] : array[0];
        }
        for (int i = 1; i < len; i++) {
            if (array[i - 1] != nums[i - 1]) {
                if (array[i - 1] >= nums[i + k - 1]) {
                    array[i] = array[i - 1];
                } else {
                    array[i] = nums[i + k - 1];
                }
            } else {
                int tempLength = i + k;
                array[i] = nums[i];
                for (int j = i + 1; j < tempLength; j++) {
                    array[i] = (array[i] < nums[j]) ? nums[j] : array[i];
                }
            }
        }
        return array;
    }

    // 解法2：最大队列
    public static int[] maxSlidingWindow1(int[] nums, int k) {

        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            // 队列不为空，新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            // 如果首位值（即最大值）不在窗口区间，删除首位
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            // 队列不为空，新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            // 窗口最大值等于队列首部元素
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
