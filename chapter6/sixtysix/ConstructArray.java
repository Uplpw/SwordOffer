package com.java.offer.chapter6.sixtysix;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：构建乘积数组
 */
public class ConstructArray {
    // 使用除法
    public static int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int mul = 1;
        int length = a.length;
        int[] b = new int[length];
        int zero = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] == 0) {
                zero++;
            } else {
                mul *= a[i];
            }
        }

        for (int i = 0; i < length; i++) {
            if (a[i] == 0) {
                if (zero != 1) {
                    b[i] = 0;
                } else {
                    b[i] = mul;
                }
            } else {
                if (zero == 0) {
                    b[i] = mul / a[i];
                } else {
                    b[i] = 0;
                }
            }
        }
        return b;
    }

    // 不使用除法
    public int[] constructArr2(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int len=a.length;
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        // 先计算下三角
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 再计算上三角
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] b = constructArr(new int[]{1, 2, 3, 4, 5});
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "\t");
        }
        System.out.println();
    }
}
