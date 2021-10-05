package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer：懒汉模式（通过加锁实现）：线程安全，性能不好，同时不能防止反射与反序列化攻击问题。
 */
public class LazySingletonBySynchronized {
    private static LazySingletonBySynchronized uniqueInstance;

    public synchronized static LazySingletonBySynchronized getInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new LazySingletonBySynchronized();
        }
        return uniqueInstance;
    }

    private LazySingletonBySynchronized() {
    }
}
