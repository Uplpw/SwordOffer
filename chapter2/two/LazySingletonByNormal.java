package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer
 *
 * 懒汉模式（简单形式）：线程不安全
 */
public class LazySingletonByNormal {

    private static LazySingletonByNormal uniqueInstance;

    public static LazySingletonByNormal getInstance() {
        if (null == uniqueInstance) {
            uniqueInstance = new LazySingletonByNormal();
        }
        return uniqueInstance;
    }

    private LazySingletonByNormal() {
    }
}
