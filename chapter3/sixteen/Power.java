package com.java.offer.chapter3.sixteen;

/*
    实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Power {
    // 循环计算 注意特殊情况，可以抛出异常
    public static double power(double x, int n) throws Exception {
        if (equal(x, 0)) {
            if (n == 0) {
                return 1;
            } else if (n < 0) {
                throw new Exception("分母为0");
            }
            return 0;
        }
        if (n < 0) {
            double pow = x;
            int count = -n - 1;
            for (int i = 1; i < count; i++) {
                pow = pow * x;
            }
            return 1 / pow;
        } else {
            double pow = 1;
            for (int i = 0; i < n; i++) {
                pow = pow * x;
            }
            return pow;
        }
    }

    // 递归计算，可以抛出异常
    public static double powerRecursionly(double x, int n) throws Exception {
        if (equal(x, 0)) {
            if (n == 0) {
                return 1;
            } else if (n < 0) {
                throw new Exception("分母为0");
            }
            return 0;
        }
        if (n < 0) {
            return 1 / x * powerCoreRecursionly(1 / x, -n - 1);
        } else {
            return powerCoreRecursionly(x, n);
        }
    }

    public static double powerCoreRecursionly(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            if ((n & 1) == 0) {
                double temp = powerCoreRecursionly(x, n >> 1);
                return temp * temp;
            } else {
                double temp = powerCoreRecursionly(x, n >> 1);
                return x * temp * temp;
            }
        }
    }

    // 判断double类型是否相等，主要是判断两者之差是否在很小的区间内
    public static boolean equal(double x, double y) {
        return -0.000001 < (x - y) && (x - y) < 0.000001;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("2^3=" + powerRecursionly(2, 3));
        System.out.println("2^-3=" + powerRecursionly(2, -3));
        System.out.println("0^3=" + powerRecursionly(0, 3));
        System.out.println("0^-3=" + powerRecursionly(0, -3));
    }
}
