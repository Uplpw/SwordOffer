package com.java.offer.chapter2.thirteen;

/*
    机器人的运动范围

    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
    请问该机器人能够到达多少个格子？
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
            flag[rowIndex][colIndex] = true;
            count = 1 + moveCountCore(flag, rowIndex + 1, colIndex, m, n, k) +
                    moveCountCore(flag, rowIndex - 1, colIndex, m, n, k) +
                    moveCountCore(flag, rowIndex, colIndex + 1, m, n, k) +
                    moveCountCore(flag, rowIndex, colIndex - 1, m, n, k);
        }
        return count;
    }

    public static boolean canIn(boolean[][] flag, int rowIndex, int colIndex, int m, int n, int k) {
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= m || colIndex >= n) {
            return false;
        }
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
