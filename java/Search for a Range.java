/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

/**
 思路：二分查找，找到元素后，分别向两边延伸判断，直到不相等为止
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums == null || nums.length == 0)
            return res;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                left++;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                right--;

                res[0] = left;
                res[1] = right;

                return res;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
