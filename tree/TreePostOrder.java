package com.java.tree;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/26 9:58
 * @Description 二叉树后序遍历
 */
public class TreePostOrder {
    // 后序递归遍历
    public static void postOrderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrderRecursively(tree.left);
        postOrderRecursively(tree.right);
        System.out.print(tree.val + "\t");
    }

    // 后序非递归遍历
    public static void postOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        TreeNode prevVisted = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.peek().right;
                if (root != null && root != prevVisted) {
                    stack.push(root);
                    root = root.left;
                } else {
                    prevVisted = stack.pop();
                    System.out.print(prevVisted.val + "\t");
                    root = null;
                }
            }
        }
        System.out.println();
    }
}
