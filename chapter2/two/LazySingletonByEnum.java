package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:15
 * @Description 懒汉模式（通过枚举实现）：线程安全，能防止反射与反序列化攻击问题。
 */
public enum LazySingletonByEnum {

    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }
}
