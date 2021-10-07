package com.java.offer.chapter4.thirtyone;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：栈的压入弹出序列
 */
public class StackPushPopOrder {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        int pushedIndex = 0;
        int poppedIndex = 0;
        Stack stack = new Stack();
        while (poppedIndex < popped.length) {
            if (stack.isEmpty() || (int) stack.peek() != popped[poppedIndex]) {
                if (pushedIndex < pushed.length) {
                    stack.push(pushed[pushedIndex++]);
                } else {
                    return false;
                }
            } else {
                stack.pop();
                poppedIndex++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(push, pop1));
        System.out.println(validateStackSequences(push, pop2));
    }
}
