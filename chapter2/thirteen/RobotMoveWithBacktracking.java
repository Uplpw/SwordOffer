package com.java.offer.chapter2.thirteen;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：机器人的运动范围
 */
public class RobotMoveWithBacktracking {
    public static int moveCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        boolean[][] flag = new boolean[m][n];

        return moveCountCore(flag, 0, 0, m, n, k);
    }

    public static int moveCountCore(boolean[][] flag, int rowIndex, int colIndex, int m, int n, int k) {
        int count = 0;
        if (canIn(flag, rowIndex, colIndex, m, n, k)) {
            // 标记当前节点已走过
            flag[rowIndex][colIndex] = true;
            // 当前节点计数，以及开始下一个节点
            count = 1 + moveCountCore(flag, rowIndex + 1, colIndex, m, n, k) +
                    moveCountCore(flag, rowIndex - 1, colIndex, m, n, k) +
                    moveCountCore(flag, rowIndex, colIndex + 1, m, n, k) +
                    moveCountCore(flag, rowIndex, colIndex - 1, m, n, k);
        }
        return count;
    }

    public static boolean canIn(boolean[][] flag, int rowIndex, int colIndex, int m, int n, int k) {
        // 索引越界
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= m || colIndex >= n) {
            return false;
        }
        // 当前节点没有走过且小于k
        if ((rowOrColSum(rowIndex) + rowOrColSum(colIndex) <= k) && !flag[rowIndex][colIndex]) {
            return true;
        }
        return false;
    }

    public static int rowOrColSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("three");
        System.out.println(moveCount(16, 8, 4));
    }
}
