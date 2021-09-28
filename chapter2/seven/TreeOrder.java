package com.java.offer.chapter2.seven;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOrder {
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

    // 前序递归遍历
    public static void preorderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + "\t");
        preorderRecursively(tree.left);
        preorderRecursively(tree.right);
    }

    // 中序递归遍历
    public static void inorderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        inorderRecursively(tree.left);
        System.out.print(tree.val + "\t");
        inorderRecursively(tree.right);
    }

    // 后序递归遍历
    public static void postorderRecursively(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postorderRecursively(tree.left);
        postorderRecursively(tree.right);
        System.out.print(tree.val + "\t");
    }

    // 前序非递归遍历
    public static void preorderIteratively(TreeNode tree) {
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

    // 中序非递归遍历
    public static void inorderIteratively(TreeNode tree) {
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

    // 后序非递归遍历
    public static void postorderIteratively(TreeNode tree) {
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

    // 层次遍历（借助队列）
    public static void levelorder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val+"\t");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = init();

        System.out.println("前序递归遍历");
        preorderRecursively(root);
        System.out.println();

        System.out.println("中序递归遍历");
        inorderRecursively(root);
        System.out.println();

        System.out.println("后序递归遍历");
        postorderRecursively(root);
        System.out.println();

        System.out.println("前序非递归遍历");
        preorderIteratively(root);

        System.out.println("中序非递归遍历");
        inorderIteratively(root);

        System.out.println("后序非递归遍历");
        postorderIteratively(root);

        System.out.println("层次遍历");
        levelorder(root);
    }
}
