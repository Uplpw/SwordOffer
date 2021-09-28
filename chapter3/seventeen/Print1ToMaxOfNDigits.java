package com.java.offer.chapter3.seventeen;

import java.util.ArrayList;
import java.util.List;

/*  打印从1到最大的n位数

    比如输入2，打印1,2......98,99；
 */
public class Print1ToMaxOfNDigits {
    // 解法1：使用字符串模拟数字的加法
    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }
        // 计算位数为n的整数个数
        int length = 0;
        for (int i = 1; i <= n; i++) {
            length = length * 10 + 9;
        }
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '0';
        }
        // 记录字符数组情况
        int[] temp = new int[length];
        int index = 0;
        while (increase(array)) {
            temp[index++] = print(array);
        }
        return temp;
    }

    // 模拟加法
    public static boolean increase(char[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            // 字符不是9，字符加1
            if (array[i] < '9' && array[i] >= '0') {
                array[i] = (char) ((int) array[i] + 1);
                return true;
                // 字符不是9 当前字符改为0，进入下次for循环
            } else if (array[i] == '9') {
                array[i] = '0';
            } else {
                return false; // 无效字符
            }
        }
        // 最高位加法完成，循环结束
        return false;
    }


    // 解法2：递归解法
    public static int[] printNumbersRecursionly(int n) {
        if (n <= 0) {
            return new int[0];
        }
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '0';
        }
        // 记录字符数组情况
        int length = 0;
        for (int i = 1; i <= n; i++) {
            length = length * 10 + 9;
        }
        int[] result = new int[length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // 最高位逐步加1，然后递归低位
            array[0] = (char) ('0' + i);
            printNumbersCoreRecursionly(array, n, 0, list);
        }
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void printNumbersCoreRecursionly(char[] array, int n, int index, List<Integer> list) {
        // 递归到最低位 开始打印
        if (index == n - 1) {
            int current = print(array);
            if (current != 0) {
                list.add(current);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            // 当前位逐步加1，再次递归低位
            array[index + 1] = (char) ('0' + i);
            printNumbersCoreRecursionly(array, n, index + 1, list);
        }
    }

    // 返回字符数组代表的数字
    public static int print(char[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count = count * 10 + (int) (array[i] - '0');
        }
        return count;
    }


    public static void main(String[] args) {
        printNumbers(2);
        printNumbersRecursionly(2);
    }
}
