package com.java.offer.chapter5.fortyone;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：数据流中的中位数
 */
public class MedianFinder {
    private PriorityQueue<Integer> queue1;
    private PriorityQueue<Integer> queue2;

    public MedianFinder() {
        // 小顶堆(java 默认)
        queue1 = new PriorityQueue<Integer>();
        // 大顶堆
        queue2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
    }

    public void addNum(int num) {
        if (queue1.size() == queue2.size()) {
            queue2.offer(num);
            queue1.offer(queue2.poll());
        } else {
            queue1.offer(num);
            queue2.offer(queue1.poll());
        }
    }

    public double findMedian() {
        if (queue1.size() == queue2.size()) {
            return 1.0 * (queue1.peek() + queue2.peek()) / 2;
        } else {
            return queue1.peek();
        }
    }
}
