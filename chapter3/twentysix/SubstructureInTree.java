package com.java.offer.chapter3.twentysix;

public class SubstructureInTree {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                result = tree1HasTree2FromRoot(A, B);
            }
            if (!result) {
                result = isSubStructure(A.left, B);
            }
            if (!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    public static boolean tree1HasTree2FromRoot(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        return tree1HasTree2FromRoot(A.left, B.left) && tree1HasTree2FromRoot(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(3);

        System.out.println(isSubStructure(root1, root2));
        System.out.println(isSubStructure(root1, root3));
    }
}
