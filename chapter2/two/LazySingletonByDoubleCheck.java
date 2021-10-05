package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer：饿汉模式（通过双重检验锁创建）：线程安全，不能防止反射与反序列化攻击问题。
 */
public class LazySingletonByDoubleCheck {
    private static volatile LazySingletonByDoubleCheck uniqueInstance;

    public static LazySingletonByDoubleCheck getInstance() {
        if (null == uniqueInstance) {
            synchronized (LazySingletonByDoubleCheck.class) {
                if (null == uniqueInstance) {
                    uniqueInstance = new LazySingletonByDoubleCheck();
                }
            }
        }
        return uniqueInstance;
    }

    private LazySingletonByDoubleCheck() {
    }
}
