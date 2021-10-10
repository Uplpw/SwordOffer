package com.java.offer.chapter6.fiftyfive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉树的深度
 */
public class TreeDepth {
    // 解法1：层次遍历
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    // 解法2：利用递归，当前节点比其子节点的深度大1
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return (left > right) ? (left + 1) : (right + 1);
    }

    public static void main(String[] args) {
        //     5
        //  3     7
        // 2 4   6 8
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);

        // 第一层
        TreeNode root = new TreeNode(0);

        // 第二层
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);

        // 第三层
        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);

        // 第四层
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);

        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);


        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
