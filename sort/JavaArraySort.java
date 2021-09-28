package com.java.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author lpw
 * @Date 2021/9/24 16:34
 * @Description Java库排序：Array.sort()
 */
public class JavaArraySort {
    /**
     * @param array：待排序数据 说明：基本类型，默认升序
     */
    public static void sort1(int[] array) {
        System.out.println("升序前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Arrays.sort(array);
        System.out.println("升序后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param array：待排序数据 说明：基本类型，降序
     */
    public static void sort2(Integer[] array) {
        System.out.println("降序前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // 1. 直接使用官方提供的
        Arrays.sort(array, Collections.reverseOrder());

        // 2. 使用匿名内部类实现
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 3. 同样可以创建实现Comparator接口的类即可
        Arrays.sort(array, new MyIntegerComparator());

        System.out.println("降序后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param array 待排序数据 说明：对象类型，升序
     */
    public static void sort3(Student[] array) {
        System.out.println("升序前：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("按学号升序后：");
        // 1. 对象类型排序：对象类实现Comparable<T>接口并实现其方法compareTo()，升序降序改变逻辑即可
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // 2. （推荐）对象类型排序：创建一个实现一个Comparator<T>接口并实现其方法compare()，升序降序改变逻辑即可
        Arrays.sort(array, new StudentSortByScore());

        System.out.println("按成绩升序后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayInt = {3, 1, 5, 2, 6, 7, 9, 1};

        // 基本类型——整型（浮点型一样）——默认升序
        sort1(arrayInt);

        Integer[] arrayInteger = {3, 1, 5, 2, 6, 7, 9, 1};

        // 基本类型——整型（浮点型一样）——降序
        sort2(arrayInteger);

        Student[] arrayStudent = {
                new Student(102, "Tom", 99),
                new Student(105, "Lucy", 80),
                new Student(100, "Jerry", 90),
                new Student(103, "Tony", 98)
        };
        // 对象类型（Student类）——默认按学号升序
        sort3(arrayStudent);
    }
}
