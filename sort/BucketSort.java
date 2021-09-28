package com.java.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/25 18:27
 * @Description 桶排序
 */
public class BucketSort {
    public static List<Integer> sort(List<Integer> nums, int bucketSize) {
        if (nums == null || nums.size() < 2 || bucketSize < 1) {
            return nums;
        }
        int max = nums.get(0);
        int min = nums.get(0);
        // 找到最大值最小值
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > max)
                max = nums.get(i);
            if (nums.get(i) < min)
                min = nums.get(i);
        }
        // 根据桶的大小从而设置桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        // 新建桶集合，并将所有桶加入
        List<List<Integer>> bucketArray = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucketArray.add(new ArrayList<>());
        }

        // 将待排序数组元素加入到对应的桶中
        for (int i = 0; i < nums.size(); i++) {
            bucketArray.get((nums.get(i) - min) / bucketSize).add(nums.get(i));
        }

        // 新建数组保存结果
        List<Integer> resultArray = new ArrayList<>();

        // 对桶集合中每个桶进行排序，并将排序后的元素添加到结果数组中
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> everyBucket = bucketArray.get(i);
            if (everyBucket.size() > 0) {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                // 在这里可以使用其他排序方法，如插入排序
                // 这里递归调用桶排序进行排序
                List<Integer> temp = sort(everyBucket, bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    // 合并数据
                    resultArray.add(temp.get(j));
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] numsArray = {3, 1, 5, 2, 6, 7, 9, 1};
//        int[] numsArray = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] numsArray = {8, 7, 6, 5, 4, 3, 2, 1};
//        int[] numsArray = {8};
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numsArray.length; i++) {
            nums.add(numsArray[i]);
        }

        System.out.println("排序前：");
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();

        List<Integer> result = sort(nums, 5);
        System.out.println("排序后：");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
}
