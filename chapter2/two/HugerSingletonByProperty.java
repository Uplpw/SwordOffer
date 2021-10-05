package com.java.offer.chapter2.two;

/**
 * @Author lpw
 * @Date 2021/9/23 14:02
 * @Description 剑指offer：饿汉模式（通过属性创建）：线程安全，耗费资源。
 */
public class HugerSingletonByProperty {
    private static final HugerSingletonByProperty uniqueInstance = new HugerSingletonByProperty();

    private HugerSingletonByProperty() {
    }

    public static HugerSingletonByProperty getInstance() {
        return uniqueInstance;
    }
}
