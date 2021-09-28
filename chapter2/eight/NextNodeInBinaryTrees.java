package com.java.offer.chapter2.eight;

public class NextNodeInBinaryTrees {
    public static TreeNodeWithParent getNext(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        // 当前节点有右孩子
        if (node.right != null) {
            TreeNodeWithParent next_node = node.right;
            while (next_node.left != null) {
                next_node = next_node.left;
            }
            return next_node;
        }

        // 没有右孩子，分为几种情况
        while (true) {
            // 没有父节点
            if (node.father == null) {
                return null;
            }
            // 当前节点是父节点的左节点
            if (node.father.left == node) {
                return node.father;
            }
            // 当前节点是父节点的右节点
            if (node.father.right == node) {
                node = node.father;
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeWithParent root = new TreeNodeWithParent(1);

        root.left = new TreeNodeWithParent(2);
        root.left.father = root;

        root.right = new TreeNodeWithParent(3);
        root.right.father = root;

        root.left.left = new TreeNodeWithParent(4);
        root.left.left.father = root.left;

        root.left.right = new TreeNodeWithParent(5);
        root.left.right.father = root.left;

        root.right.left = new TreeNodeWithParent(6);
        root.right.left.father = root.right;

        root.right.right = new TreeNodeWithParent(7);
        root.right.right.father = root.right;

        root.left.right.left = new TreeNodeWithParent(8);
        root.left.right.left.father = root.left.right;

        root.left.right.right = new TreeNodeWithParent(9);
        root.left.right.right.father = root.left.right;

        System.out.println(root.left.val + "->" + getNext(root.left).val); // 2->8

        System.out.println(root.val + "->" + getNext(root).val); // 1->6

        System.out.println(root.left.right.right.val + "->" + getNext(root.left.right.right).val); // 9->1

        System.out.println(root.right.right.val + "->" + getNext(root.right.right)); // 7->null

//        System.out.println(getNext(root.right));

    }
}
