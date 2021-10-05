package com.java.offer.chapter2.fifteen;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：二进制中1的个数
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
