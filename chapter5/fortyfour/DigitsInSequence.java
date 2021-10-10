package com.java.offer.chapter5.fortyfour;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：数字序列中某一位的数字
 */
public class DigitsInSequence {
    public static int findNthDigit(int n) {
        if (n < 0) {
            return -1;
        }
        // digit ：表示 digit 位数
        // max : 表示 dight 位数的最大下标
        // lastMax : 表示 dight - 1 位数的最大下标
        int max = 9, lastMax = 0;
        int digit = 1;
        // 找到这个数是几位数，也就是更新 digit 的过程
        while (n > max) {
            digit++;
            lastMax = max;
            max += digit * 9 * Math.pow(10, digit - 1);
        }
        // 根据这个数的位数，就可以求出索引为n是哪个数的第几位
        int num = (n - lastMax) / digit + (int) Math.pow(10, digit - 1);
        int nth = (n - lastMax) % digit;
        // 特殊情况 余数为0时，更新 nth 为这个数的最后一位
        if (nth == 0) {
            num--;
            nth = digit;
        }
        // 将求出的数 num 转化为 字符串，返回第 nth 位
        return String.valueOf(num).charAt(nth - 1) - '0';

    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(111));
    }
}
