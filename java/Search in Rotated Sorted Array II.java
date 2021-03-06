/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Write a function to determine if a given target is in the array.
 */

public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;
        int first = 0, last = A.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (A[mid] == target)
                return true;
            else if (A[mid] > A[first]) {
                if (target >= A[first] && target < A[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            } else if (A[mid] < A[first]) {
                if (target > A[mid] && target <= A[last])
                    first = mid + 1;
                else
                    last = mid - 1;
            } else {
                if (A[first] == target)
                    return true;
                else
                    first++;
            }
        }
        return false;
    }
}
