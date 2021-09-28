package com.java.offer.chapter2.two;

import java.io.ObjectStreamException;

/**
 * @Author lpw
 * @Date 2021/9/23 16:01
 * @Description 双重检验锁：为了防止反射以及反序列化攻击而进行优化
 * <p>
 * 防止反射：在私有构造方法中抛出异常
 * <p>
 * 防止反序列化：1. 使其不能反序列化 2. 使用
 */
public class LazySingletonByDoubleCheck2 {
    private static volatile LazySingletonByDoubleCheck2 uniqueInstance;

    public static LazySingletonByDoubleCheck2 getInstance() {
        if (null == uniqueInstance) {
            synchronized (LazySingletonByDoubleCheck.class) {
                if (null == uniqueInstance) {
                    uniqueInstance = new LazySingletonByDoubleCheck2();
                }
            }
        }
        return uniqueInstance;
    }

    // 预防反射攻击
    private LazySingletonByDoubleCheck2() {
        if (uniqueInstance != null) {
            throw new RuntimeException("已存在实例，别想用反射来搞我！");
        }
    }

    /*
        预防反序列化：定义Object readResolve()方法
        这个方法会紧挨着readObject()之后被调用，该方法的返回值将会代替原来反序列化的对象，而原来readObject()反序列化的对象将会立即丢弃。
     */
    private Object readResolve() throws ObjectStreamException {
        return uniqueInstance;
    }
}