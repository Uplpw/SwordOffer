package com.java.offer.chapter2.ten;

/*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
    解决：可以看出斐波那契数列问题，先从简单问题看

    此类问题还有：用方格去填充方格，可以横着放或者竖着放

    总之：从简单实例发现问题本质
 */
public class FrogJumping {
    public static int frogJumping(int n) {
        int fibonacci = 0;
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int n_2 = 1;
            int n_1 = 1;
            for (int i = 2; i <= n; i++) {
                int temp = n_2 % 1000000007;
                n_2 = n_1 % 1000000007;
                n_1 = (temp + n_1) % 1000000007;
            }
            fibonacci = n_1;
        }
        return fibonacci;
    }

    public static void main(String[] args){
        System.out.println(frogJumping(1));
        System.out.println(frogJumping(2));
        System.out.println(frogJumping(3));
    }
}
