package com.java.offer.chapter4.thirtytwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：从上到下打印二叉树-I
 */
public class PrintTreeFromTopToBottom1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        // 比 LinkList 好一些
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = (TreeNode) queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
