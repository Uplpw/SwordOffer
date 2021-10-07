package com.java.offer.chapter4.thirtyeight;

import java.util.*;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：字符串的组合
 */
public class StringCombination {
    public static String[] combination(String s) {
        if (s == null || s.length() == 0)
            return null;
        boolean[] bool = new boolean[s.length()];
        Set<String> list = new HashSet<>();
        combinationCore(bool, s, list, 0);
        int length = list.size();
        String[] array = new String[length];
        Iterator<String> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            array[index++] = it.next();
        }
        return array;
    }

    public static void combinationCore(boolean[] bool, String s, Set<String> list, int index) {
        if (index == s.length()) {
            String str = boolean2String(bool, s);
            if (!str.equals("")) {
                list.add(str);
            }
        }
        int length = bool.length;
        for (int i = index; i < length; i++) {
            combinationCore(bool, s, list, index + 1);
            bool[i] = !bool[i];
            combinationCore(bool, s, list, index + 1);
        }

    }

    public static String boolean2String(boolean[] bool, String s) {
        String str = "";
        for (int i = 0; i < bool.length; i++) {
            if (bool[i] == true) {
                str += s.charAt(i);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "abc";
        String[] str = combination(s);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
