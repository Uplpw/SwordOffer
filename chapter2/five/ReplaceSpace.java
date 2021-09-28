package com.java.offer.chapter2.five;

/**
 * @Author lpw
 * @Date 2021/9/22 16:34
 * @Description 剑指offer
 *
 * 替换空格
 */
public class ReplaceSpace {
    public static String replaceSpace1(String s) {
        // 解法2
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        char[] replaceArray = new char[length + spaceCount * 2];
        int index = 0;
        // 从头或者从尾都一样
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                replaceArray[index++] = '%';
                replaceArray[index++] = '2';
                replaceArray[index++] = '0';
            } else {
                replaceArray[index++] = s.charAt(i);
            }
        }
        return String.valueOf(replaceArray);
    }

    // 解法3
    public static String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace1(s));
        System.out.println(replaceSpace2(s));
    }
}
