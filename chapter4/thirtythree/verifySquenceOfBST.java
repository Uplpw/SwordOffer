package com.java.offer.chapter4.thirtythree;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉搜索树的后序遍历
 */
public class verifySquenceOfBST {
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public static boolean recur(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int temp = start;
        // 找到右子树结点第一次出现的地方。（或者说是遍历完整棵左子树）
        for (int i = start; i <= end; ++i) {
            if (postorder[i] < postorder[end]) {
                temp = i;
            } else break;
        }
        // 后序遍历右子树时会访问的第一个结点的下标。
        int rightTreeNode = temp + 1;
        // 验证右子树所有结点是否都大于根结点。
        for (int i = rightTreeNode; i < end; ++i) {
            if (postorder[i] > postorder[end]){
                ++rightTreeNode;
            }else {
                return false;
            }
        }
        return recur(postorder, start, temp) && recur(postorder, temp + 1, end - 1);
    }


    public static void main(String[] args) {
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5, 7, 6, 9, 4, 10, 8};
        int[] data1 = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifyPostorder(data));
        System.out.println(verifyPostorder(data1));
    }
}
