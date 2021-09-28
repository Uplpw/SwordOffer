package com.java.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lpw
 * @Date 2021/9/26 10:00
 * @Description 二叉树层序遍历
 */
public class TreeLevelOrder {
    // 层次遍历并顺序打印（借助队列）
    public static void levelOrder1(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + "\t");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    // 层次遍历并逐层打印（借助队列）
    public static void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode temp = (TreeNode) queue.poll();
                System.out.print(temp.val + "\t");
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static TreeNode init() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = init();

        System.out.println("层次遍历1:");
        levelOrder1(root);
        System.out.println("层次遍历2:");
        levelOrder2(root);
    }
}
