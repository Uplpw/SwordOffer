package com.java.offer.chapter4.thirtyseven;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：序列化二叉树
 */
public class SerializeBinaryTrees {
    // 递归实现前序遍历，并实现序列化
    public static String serialize(TreeNode root) {
        if (root == null)
            return "null,";
        StringBuilder result = new StringBuilder();
        result.append(root.val);
        result.append(",");
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }

    // 反序列化
    public static TreeNode deserialize(String data) {
        StringBuilder stringBuilder = new StringBuilder(data);
        return deserializeCore(stringBuilder);
    }

    public static TreeNode deserializeCore(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0)
            return null;
        // 取出根节点的值
        String num = stringBuilder.substring(0, stringBuilder.indexOf(","));
        // 为了之后方便递归，删除当前节点
        stringBuilder.delete(0, stringBuilder.indexOf(","));
        // 删除多余 ','
        stringBuilder.deleteCharAt(0);
        // 根节点为空，直接返回null
        if (num.equals("null"))
            return null;
        // 根据取出的根节点值，创建节点
        TreeNode node = new TreeNode(Integer.parseInt(num));
        // 递归创建左子树、右子树
        node.left = deserializeCore(stringBuilder);
        node.right = deserializeCore(stringBuilder);
        return node;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        String result = serialize(root);
        System.out.println("序列化结果：" + result);
    }
}
