package com.java.offer.chapter2.seven;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：重建二叉树
 */
public class ConstructBinaryTree {

    /**
     * @param preorder：先序遍历结果
     * @param inorder：中序遍历结果
     * @return : 构建完成的二叉树根节点
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 无效数据判断
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        // 递归调用
        return constructCore(preorder, 0, inorder, 0, preorder.length);
    }

    /**
     * @param preorder：当前子树的先序遍历结果（实际上还是整个结果，使用preStart作为标志）
     * @param preStart：记录子树先序遍历的开始
     * @param inorder：当前子树的中序遍历结果（实际上还是整个结果，使用inStart作为标志）
     * @param inStart：记录子树中序遍历的开始
     * @param length：当前子树的节点数量
     * @return
     */
    public static TreeNode constructCore(int[] preorder, int preStart, int[] inorder, int inStart, int length) {
        // 左右子树集合为空，构建完成直接返回
        if (length == 0) {
            return null;
        }
        int index = -1;
        // 查找根节点在中序遍历中的索引位置
        for (int i = inStart; i < inStart + length; i++) {
            if (preorder[preStart] == inorder[i]) {
                index = i;
                break;
            }
        }
        // 左子树的节点数量
        int preorder_length = index - inStart;
        // 构建根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        /*
            递归左子树构建
            参数preStart：由于是构建左子树，先序第一个节点是根节点，所以左子树集合开始索引需要+1
            参数inStart：由于中序遍历左边结果一定是左子树，所以不进行更新
            参数length：左子树节点数量=preorder_length
         */
        root.left = constructCore(preorder, preStart + 1, inorder, inStart, preorder_length);

        /*
            递归右子树构建
            参数preStart：由于是构建右子树，右子树集合开始的索引在 根节点开始索引+左子树节点数量+1
            参数inStart：由于中序遍历中根节点右边的数据一定是右节点，所以右子树开始索引是 index+1
            参数length：右子树节点数量=length - preorder_length - 1（当前子树节点数量-左子树节点数量-根节点）
         */
        root.right = constructCore(preorder, preStart + preorder_length + 1, inorder, index + 1,
                length - preorder_length - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};

        TreeNode root = buildTree(preorder, inorder);
        TreeOrder.preorderRecursively(root);
        System.out.println();
        TreeOrder.inorderRecursively(root);
    }
}
