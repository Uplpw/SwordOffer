package com.java.offer.chapter4.thirtysix;

/**
 * @Author lpw
 * @Date 2021/10/7 22:02
 * @Description
 */
public class ConvertBinarySearchTreeByDFS {
    static TreeNode pre, head;

    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        // 进行头节点和尾节点的相互指向，此时pre已指向最后的节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 递归左子树
        dfs(cur.left);
        // pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if (pre != null) {
            pre.right = cur;
        } else {
            // pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
            head = cur;
        }
        // 当前节点左指针指向前节点
        cur.left = pre;
        // pre指向当前的cur
        pre = cur;
        // 递归右子树
        dfs(cur.right);
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
