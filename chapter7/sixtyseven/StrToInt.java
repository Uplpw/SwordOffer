package com.java.offer.chapter7.sixtyseven;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：把字符串转换成整数
 */
public class StrToInt {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int len = str.length();
        long temp = 0;
        boolean flag = true;
        int index = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            flag = str.charAt(0) == '+' ? true : false;
            index++;
        }
        for (int i = index; i < len; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                temp = temp * 10 + (int) (str.charAt(i) - '0');
                if (flag && temp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (-1 * temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else break;
        }
        if (flag)
            return (int) temp;
        else
            return -(int) temp;
    }

    // 不使用trim
    public static int strToInt2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        long temp = 0;
        boolean flag = true;
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }
        if (index == len) {
            return (int) temp;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            flag = str.charAt(0) == '+' ? true : false;
            index++;
        }
        for (int i = index; i < len; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                temp = temp * 10 + (int) (str.charAt(i) - '0');
                if (flag && temp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (-1 * temp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else break;
        }
        if (flag)
            return (int) temp;
        else
            return -(int) temp;
    }

    public static void main(String[] args) {
//        System.out.println(strToInt("42"));
//        System.out.println(strToInt("      -42"));
//        System.out.println(strToInt("4193 with words"));
//        System.out.println(strToInt("words and 987"));
//        System.out.println(strToInt("21111111111111111111112187"));
//        System.out.println(strToInt("-3123214345234523353454"));

        System.out.println(strToInt2("211111asdas"));
        System.out.println(strToInt2("-3+4-"));
    }
}
