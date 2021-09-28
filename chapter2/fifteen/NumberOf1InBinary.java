package com.java.offer.chapter2.fifteen;

/*
    二进制中1的个数（位运算）

    实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
    例如9->1001,输出2；-3->11111111111111111111111111111101, 输出31。

    注意：整型是32位
 */
public class NumberOf1InBinary {
    // 解法1：无符号右移 >>>，与1进行与操作，返回不为0即为1
    public static int numberOfOne1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    // 解法2：有符号左移 << ，与1异或，判断结果是否为1
    public static int numberOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    // 解法3：把一个整数减去 1 后再与其做与运算，相当于把整数的二进制最右边的 1 变成 0
    public static int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            // 注意 & 的优先级比较低，需要使用括号
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("正数");
        System.out.println(numberOfOne1(3));
        System.out.println(numberOfOne2(3));
        System.out.println(numberOfOne3(3));
        System.out.println("负数");
        System.out.println(numberOfOne1(-3));
        System.out.println(numberOfOne2(-3));
        System.out.println(numberOfOne3(-3));
    }
}
