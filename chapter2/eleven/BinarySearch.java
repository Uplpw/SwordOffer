package com.java.offer.chapter2.eleven;

/**
 * @Author lpw
 * @Date 2021/9/23 20:19
 * @Description 剑指offer：二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int start, int end, int target) {
        if (array == null || array.length == 0 || start < 0 || start >= array.length || end < 0 || end >= array.length
                || start > end) {
            return -1;
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 0, 6, 10));
        System.out.println(binarySearch(array, 0, 6, 3));
        System.out.println(binarySearch(array, 0, 6, 7));
    }
}
