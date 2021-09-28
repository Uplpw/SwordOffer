package com.java.sort;

import java.util.Comparator;

/**
 * @Author lpw
 * @Date 2021/9/24 17:19
 * @Description
 */
public class StudentSortByScore implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.score - o2.score;
    }
}
