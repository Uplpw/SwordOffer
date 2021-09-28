package com.java.offer.chapter2.twelve;

public class HasPathWithBacktracking {
    public static boolean hasPath(char[][] board, String str) {
        if (board == null || board.length == 0 || str == null || str.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (hasPathCore(board, i, j, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] board, int rowIndex, int colIndex, boolean[][] flag, String str, int strIndex) {
        // 递归结束条件
        if (strIndex >= str.length()) {
            return true;
        }
        // 防止下面的索引越界
        if (rowIndex < 0 || colIndex < 0 || rowIndex >= board.length || colIndex >= board[0].length) {
            return false;
        }
        if (!flag[rowIndex][colIndex] && board[rowIndex][colIndex] == str.charAt(strIndex)) {
            flag[rowIndex][colIndex] = true;
            boolean result = hasPathCore(board, rowIndex + 1, colIndex, flag, str, strIndex + 1) ||
                    hasPathCore(board, rowIndex - 1, colIndex, flag, str, strIndex + 1) ||
                    hasPathCore(board, rowIndex, colIndex + 1, flag, str, strIndex + 1) ||
                    hasPathCore(board, rowIndex, colIndex - 1, flag, str, strIndex + 1);
            if (result == true) {
                return true;
            } else {
                // 重新设置flag值，防止对其他路径有影响
                flag[rowIndex][colIndex] = false;
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] data = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        System.out.println(hasPath(data, "bfce")); //true
        System.out.println(hasPath(data, "abfb")); //false,访问过的位置不能再访问
    }
}
