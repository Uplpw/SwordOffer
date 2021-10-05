package com.java.offer.chapter2.one;

/**
 * @Author lpw
 * @Date 2021/9/22 16:34
 * @Description 剑指offer：赋值运算符
 */
public class MyAssignment {

    private String data;

    public MyAssignment(String data) {
        this.data = data;
    }

    // 注意传入参数final修饰符，以及传入引用与当前引用的比较，不需要主动释放内存，返回类型为引用类型
    public MyAssignment assign(final MyAssignment another) {
        if (this == another || this.data.equals(another.data))
            return this;
        else {
            this.data = another.data;
            return this;
        }
    }

    @Override
    public String toString() {
        return "data=" + data;
    }

    public static void main(String[] args) {
        MyAssignment str1 = new MyAssignment("111");
        MyAssignment str2 = new MyAssignment("222");
        MyAssignment str3 = new MyAssignment("333");
        str1.assign(str2).assign(str3);
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        System.out.println("str3:" + str3);
    }
}
