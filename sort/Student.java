package com.java.sort;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * @Author lpw
 * @Date 2021/9/24 17:01
 * @Description Student类
 */
public class Student implements Comparable<Student>{
    public int id;
    public String name;
    public int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Integer.compare(this.id, o.id);
    }
}
