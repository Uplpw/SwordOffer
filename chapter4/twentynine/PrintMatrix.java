package com.java.offer.chapter4.twentynine;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：顺时针打印矩阵
 */
public class PrintMatrix {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new int[0];
        }
        if(matrix.length==0){
            return new int[0];
        }
        int length = matrix.length * matrix[0].length;
        int[] array = new int[length];
        spiralOrderCore(array, 0, matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return array;
    }

    public static void spiralOrderCore(int[] array, int index, int[][] matrix, int rowStart, int rowEnd,
                                       int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) {
            return;
        }
        int count = index;
        // 只有一行
        if (rowStart == rowEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                array[count++] = matrix[rowStart][j];
            }
            return;
        }
        // 只有一列
        if (colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                array[count++] = matrix[i][colStart];
            }
            return;
        }
        // 矩阵第一行
        for (int j = colStart; j <= colEnd; j++) {
            array[count++] = matrix[rowStart][j];
        }
        // 矩阵最后一列
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            array[count++] = matrix[i][colEnd];
        }
        // 矩阵最后一行
        for (int j = colEnd - 1; j >= colStart; j--) {
            array[count++] = matrix[rowEnd][j];
        }
        // 矩阵最左一列
        for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
            array[count++] = matrix[i][colStart];
        }

        spiralOrderCore(array, count, matrix, rowStart + 1, rowEnd - 1, colStart + 1, colEnd - 1);
    }

    public static void main(String[] args) {
        int[][] data1 = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };
        int[][] data2 = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6},
        };
        int[][] data3 = {
                {1, 2, 3},
                {10, 11, 4},
                {9, 12, 5},
                {8, 7, 6},
        };
        int[][] data4 = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };

        int[] array = spiralOrder(data3);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
