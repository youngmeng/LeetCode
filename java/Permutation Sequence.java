/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 */

import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        // 将数字初始化到list中
        ArrayList<Integer> numList = new ArrayList<Integer>();

        // mod为待求的n的阶乘
        int mod = 1;

        for (int i = 1; i <= n; i++) {
            numList.add(i);
            mod *= i;
        }

        //将k变为索引（脚标）
        k--;

        String result = "";

        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int index = k / mod;//k位于第几个(n-1)!的组中

            //index对应于list
            result += numList.get(index);
            numList.remove(index);

            k %= mod;//求出k位于所在组中的第几个，从0开始
        }

        return result;
    }
}
