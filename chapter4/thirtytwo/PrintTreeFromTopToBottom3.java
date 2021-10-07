package com.java.offer.chapter4.thirtytwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：从上到下打印二叉树-III
 */
public class PrintTreeFromTopToBottom3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if (root == null) {
            return list;
        }

        Queue queue = new LinkedList();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            List<Integer> tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode temp = (TreeNode) queue.poll();
                tempList.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 根据规律将存储的元素对称互换即可
            if ((count & 1) == 0) {
                int length = tempList.size();
                for (int i = 0; i < length / 2; i++) {
                    int temp = tempList.get(i);
                    tempList.set(i, tempList.get(length - 1 - i));
                    tempList.set(length - 1 - i, temp);
                }
            }
            list.add(tempList);
        }
        return list;
    }
}
