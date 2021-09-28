package com.java.tree;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/26 9:53
 * @Description 二叉树前序遍历
 */
public class TreePreOrder {
    // 前序递归遍历
    public static void preOrderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + "\t");
        preOrderRecursively(tree.left);
        preOrderRecursively(tree.right);
    }

    // 前序非递归遍历
    public static void preOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                System.out.print(root.val + "\t");
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        System.out.println();
    }
}
