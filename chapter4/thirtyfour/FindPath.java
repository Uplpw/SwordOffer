package com.java.offer.chapter4.thirtyfour;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：二叉树中和为某一值的路径
 */
public class FindPath {
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        List<Integer> current = new ArrayList<>();
        pathSumCore(root, target, list, current, 0);
        return list;
    }

    public static void pathSumCore(TreeNode root, int target, List<List<Integer>> list, List<Integer> current, int value) {
        current.add(root.val);
        value = value + root.val;
        if (root.left != null)
            pathSumCore(root.left, target, list, current, value);
        if (root.right != null)
            pathSumCore(root.right, target, list, current, value);
        if (value == target && root.left == null && root.right == null) {
            // 由于current是引用类型，在下面操作后，即使加入list也会发生变化，所以要创建新的对象
            List<Integer> addList = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
               addList.add(current.get(i));
            }
            list.add(addList);
        }
        current.remove(current.size() - 1);
    }
}
