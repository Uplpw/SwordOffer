package com.java.offer.chapter7.sixtyeight;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉树中两个节点的最低公共祖先
 */
public class LowestCommonAncestor2 {
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null && right == null) return null; // 1.
        if (left == null) return right; // 3.
        if (right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}
