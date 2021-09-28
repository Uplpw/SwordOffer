package com.java.offer.chapter2.eleven;

/*
    二分查找

    方法内包含四个参数，分别是已排好序的数组（二分查找的前提是数组已经有序），待查找的起始索引start，待查找的结束索引end，目标元素target。
    首先找到数组中的中间元素的索引，即mid = start + (end - start) / 2;比较mid指向元素与target是否相等，若相等则查找成功；若target比mid指向元素小，
    则target在mid的左边，则下次查找的结束位置为mid-1;若target比mid指向元素大，则下次查找的起始范围为mid+1;
    不断迭代直到start和end交叉开来，即start > end时，循环结束

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
