package com.java.offer.chapter2.eight;

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