package com.java.tree;

import java.util.Stack;

/**
 * @Author lpw
 * @Date 2021/9/26 9:56
 * @Description 二叉树中序遍历
 */
public class TreeInOrder {
    // 中序递归遍历
    public static void inOrderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inOrderRecursively(tree.left);
        System.out.print(tree.val + "\t");
        inOrderRecursively(tree.right);
    }

    // 中序非递归遍历
    public static void inOrderIteratively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode root = tree;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                System.out.print(stack.peek().val + "\t");
                root = stack.pop().right;
            }
        }
        System.out.println();
    }
}
