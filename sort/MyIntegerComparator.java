package com.java.sort;

import java.util.Comparator;

/**
 * @Author lpw
 * @Date 2021/9/24 16:57
 * @Description 实现Comparator接口的类
 */
public class MyIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
