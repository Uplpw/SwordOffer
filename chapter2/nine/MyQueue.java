package com.java.offer.chapter2.nine;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：用两个栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void offer(Integer data) {
        stack1.push(data);
    }

    public Integer poll() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    Integer data = stack1.pop();
                    stack2.push(data);
                }
                return stack2.pop();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.poll());
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.offer(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
