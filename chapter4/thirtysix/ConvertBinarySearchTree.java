package com.java.offer.chapter4.thirtysix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉搜索树与双向链表
 */
public class ConvertBinarySearchTree {
    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        List<TreeNode> list = new ArrayList();
        getList(root, list);
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                list.get(i).left = list.get(length - 1);
                list.get(i).right = list.get(i + 1);
            } else if (i == length - 1) {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(0);
            } else {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(i + 1);
            }

        }
        return list.get(0);
    }

    // 中序遍历
    public static void getList(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        getList(root.left, list);
        list.add(root);
        getList(root.right, list);
    }

    public static void main(String[] args) {
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        treeToDoublyList(root);
    }
}
