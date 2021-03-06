/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

/*
 *先排序，再遍历数组，遍历的过程中采用夹逼的方式获取另外两个数
 */

import java.util.Arrays;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (num.length < 3)
            return list;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            int left = i + 1;
            int right = num.length - 1;

            while (left < right) {
                if (-num[i] == num[left] + num[right]) {
                    List<Integer> sublist = new ArrayList<Integer>();
                    sublist.add(num[i]);
                    sublist.add(num[left]);
                    sublist.add(num[right]);
                    list.add(sublist);

                    while (left + 1 < right && num[left + 1] == num[left])
                        left++;
                    left++;

                    while (right - 1 > left && num[right - 1] == num[right])
                        right--;
                    right--;
                } else if (-num[i] > num[left] + num[right]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return list;
    }
}
