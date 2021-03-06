/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Solution {
    /*
     *动态规划思想
     *f(i):以nums[i]结尾的最大连续子序列和
     */
    public int maxSubArray(int[] nums) {
        int f = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            f = Integer.max(f + nums[i], nums[i]);
            res = Integer.max(res, f);
        }

        return res;
    }
}
