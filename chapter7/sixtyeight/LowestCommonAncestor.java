package com.java.offer.chapter7.sixtyeight;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉搜索树中两个节点的最低公共祖先
 */
public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > q.val)
            return lowestCommonAncestorCore(root, q, p);
        else
            return lowestCommonAncestorCore(root, p, q);
    }

    public static TreeNode lowestCommonAncestorCore(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorCore(root.left, p, q);
        } else {
            return lowestCommonAncestorCore(root.right, p, q);
        }
    }
}
