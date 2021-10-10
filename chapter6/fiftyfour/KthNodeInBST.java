package com.java.offer.chapter6.fiftyfour;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉搜索树的第k大节点
 */
public class KthNodeInBST {
    public static int kthLargest(TreeNode root, int k) {
        if (root == null || k < 0) {
            return -1;
        }
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        int length = list.size();
        if (k > length) {
            return -1;
        }
        return list.get(length - k).val;
    }

    public static void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }

    int count = 0;
    int res = -1;

    // 优化，不使用额外空间，第k大，则每次减一，直到为0
    public int kthLargest2(TreeNode root, int k) {
        if (root == null || k < 0) {
            return -1;
        }
        traverse2(root, k);
        return res;
    }

    public void traverse2(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        traverse2(node.right, k);
        count++;
        if (k == count) {
            res = node.val;
            return;
        }
        traverse2(node.left, k);
    }

    public static void main(String[] args) {
        // 2 3 4 5 6 7 8
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

//        System.out.println(kthLargest(root, 3)); //6
//        System.out.println(kthLargest(root, 6)); //3
//        System.out.println(kthLargest(root, 8)); //null

        System.out.println("count:" + new KthNodeInBST().kthLargest2(root, 3)); // 6
        System.out.println(new KthNodeInBST().kthLargest2(root, 6)); // 3
        System.out.println(new KthNodeInBST().kthLargest2(root, 8)); // null
    }
}
