package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer：饿汉模式（通过静态代码块创建）：线程安全，耗费资源。
 */
public class HugerSingletonByStaticBlock {
    private static final HugerSingletonByStaticBlock uniqueInstance;

    static {
        uniqueInstance = new HugerSingletonByStaticBlock();
    }

    private HugerSingletonByStaticBlock() {
    }

    public static HugerSingletonByStaticBlock getInstance() {
        return uniqueInstance;
    }
}
