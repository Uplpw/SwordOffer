package com.java.offer.chapter6.fiftyseven;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：连续和为s的数字
 */
public class ContinuousSequenceWithSum {
    public static int[][] findContinuousSequence(int target) {
        if (target <= 0) {
            return null;
        }
        int count = 0;
        int index = 1;
        List<int[]> list = new ArrayList<int[]>();
        while (index <= target / 2) {
            int sum = 0;
            int right = -1;
            int temp = index;
            while (true) {
                sum = sum + temp;
                if (sum == target) {
                    right = temp;
                    break;
                } else if (sum > target) {
                    break;
                } else {
                    temp++;
                }
            }
            if (right != -1 && right != index) {
                int[] res = new int[right - index + 1];
                for (int i = index; i <= right; i++) {
                    res[i - index] = i;
                }
                count++;
                list.add(res);
            }
            index++;
        }
        return list.toArray(new int[count][]);
    }

    // 双指针
    public static int[][] findContinuousSequence2(int target) {
        if (target <= 0) {
            return null;
        }
        int count = 0;
        List<int[]> list = new ArrayList<int[]>();
        for (int left = 1, right = 2; left < right; ) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] res = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    res[i - left] = i;
                }
                count++;
                list.add(res);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return list.toArray(new int[count][]);
    }

    // 数学优化，根据当前索引直接求解和为target的右边界right，right需要满足两个条件，
    // 判别式 b^2-4acb 开根需要为整数
    // 最后的求根公式的分子需要为偶数，因为分母为 2
    public static int[][] findContinuousSequence3(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if (i < j && j == (int) j) {
                int[] ans = new int[(int) j - i + 1];
                for (int k = i; k <= (int) j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] array = findContinuousSequence3(15);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    System.out.print(array[i][j] + "\t");
                } else break;

            }
            System.out.println();
        }
    }
}
