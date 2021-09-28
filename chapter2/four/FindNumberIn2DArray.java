package com.java.offer.chapter2.four;

/**
 * @Author lpw
 * @Date 2021/9/22 16:34
 * @Description 剑指offer
 *
 * 二维数组中的查找
 */
public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 无效输入
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 特殊情况处理（小与最小值、大于最大值，直接返回）
        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(m, 5));
        System.out.println(findNumberIn2DArray(m, 50));
    }
}