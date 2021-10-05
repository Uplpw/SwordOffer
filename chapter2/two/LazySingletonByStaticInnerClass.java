package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer：饿汉模式（通过静态内部类创建）：线程安全，不能防止反射与反序列化攻击问题。
 */
public class LazySingletonByStaticInnerClass {

    private static class SingletonHodler {
        private static final LazySingletonByStaticInnerClass uniqueInstance = new LazySingletonByStaticInnerClass();
    }

    public static LazySingletonByStaticInnerClass getInstance() {
        return SingletonHodler.uniqueInstance;
    }

    private LazySingletonByStaticInnerClass() {

    }
}
