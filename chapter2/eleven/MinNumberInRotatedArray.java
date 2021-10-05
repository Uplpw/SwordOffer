package com.java.offer.chapter2.eleven;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：旋转数组的最小数字
 */
public class MinNumberInRotatedArray {
    public static int min(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        if (numbers == null || numbers.length == 0) {
            return -1;
        } else {
            while (start < end) {
                int mid = (start + end) / 2;
                if (numbers[start] < numbers[end]) {        // start < end
                    return numbers[start];
                } else if (numbers[start] > numbers[end]) {  // start > end
                    if (numbers[mid] >= numbers[start])
                        start = mid + 1;
                    else
                        end = mid;
                } else {                                // start = end
                    if (numbers[start] < numbers[mid])
                        start = mid + 1;
                    else if (numbers[start] > numbers[mid])
                        end = mid;
                    else {
                        start = start + 1;
                        end = end - 1;
                    }
                }
            }

        }
        return numbers[end];
    }

    public static void main(String[] args) {
        int[] data1 = {3, 4, 5, 1, 2};
        int[] data2 = {1, 0, 1, 1, 1};
        int[] data3 = {1, 1, 1, 0, 1};
        System.out.println(min(data1));
        System.out.println(min(data2));
        System.out.println(min(data3));
    }
}
