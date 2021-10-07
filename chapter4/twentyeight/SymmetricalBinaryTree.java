package com.java.offer.chapter4.twentyeight;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：对称的二叉树
 */
public class SymmetricalBinaryTree {
    // 递归实现
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }

    public static boolean isSymmetricCore(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSymmetricCore(A.left, B.right) && isSymmetricCore(A.right, B.left);
    }

    // 迭代实现
    public static boolean isSymmetrical2(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (root.left == null || root.right == null)
            return false;
        Queue<TreeNode> queueLeft = new LinkedList();
        Queue<TreeNode> queueRight = new LinkedList();
        queueLeft.offer(root.left);
        queueRight.offer(root.right);
        TreeNode tempLeft, tempRight;
        while (!queueLeft.isEmpty() || !queueRight.isEmpty()) {
            boolean left = false;
            boolean right = false;
            tempLeft = queueLeft.poll();
            tempRight = queueRight.poll();
            if (tempLeft.val == (tempRight.val)) {
                // 注意顺序 左——>右
                if (tempLeft.left != null)
                    queueLeft.offer(tempLeft.left);
                else
                    left = true;
                if (tempLeft.right != null)
                    queueLeft.offer(tempLeft.right);
                else
                    right = true;
                // 注意顺序 右——>左
                if (tempRight.right != null) {
                    if (left == true) {
                        return false;
                    }
                    queueRight.offer(tempRight.right);
                } else {
                    if (left == false) {
                        return false;
                    }
                }

                if (tempRight.left != null) {
                    if (right == true) {
                        return false;
                    }
                    queueRight.offer(tempRight.left);
                } else {
                    if (right == false) {
                        return false;
                    }
                }

            } else
                return false;
        }
        if (queueLeft.isEmpty() && queueRight.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
//        System.out.println(isSymmetric(root));
        System.out.println(isSymmetrical2(root));

    }
}
