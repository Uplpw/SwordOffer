package com.java.offer.chapter2.eight;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：带有父节点指针的二叉树
 */
public class TreeNodeWithParent {
    public int val;
    public TreeNodeWithParent left;
    public TreeNodeWithParent right;
    public TreeNodeWithParent father;

    public TreeNodeWithParent(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.father = null;
    }
}
// 测试用例使用的树
//            1
//          // \\
//         2     3
//       // \\
//      4     5
//    inorder : 42513