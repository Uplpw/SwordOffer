package com.java.offer.chapter4.twentyseven;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：树的镜像
 */
public class MirrorOfBinaryTree {
    public static void mirrorRecursively(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        System.out.println(root);
        mirrorRecursively(root);
        System.out.println(root);
    }
}
