package com.java.offer.chapter4.thirty;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：包含min函数的栈
 */
public class StackWithMin {
    private Stack stackData;
    private Stack minData;

    public StackWithMin() {
        this.stackData = new Stack();
        this.minData = new Stack();
    }

    public void push(int x) {
        this.stackData.push(x);
        if (this.minData.isEmpty() || (int) this.minData.peek() >= x) {
            this.minData.push(x);
        } else {
            this.minData.push(this.minData.peek());
        }
    }

    public void pop() {
        if (this.stackData.isEmpty()) {
            return;
        } else {
            this.stackData.pop();
            this.minData.pop();
        }
    }

    public int top() {
        return (int) this.stackData.peek();
    }

    public int min() {
        if (this.minData.isEmpty()) {
            return -1;
        } else {
            return (int) this.minData.peek();
        }
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
