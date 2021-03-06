/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 */

public class Solution {
    public int maxArea(int[] height) {
        if (height == null)
            return 0;

        int first = 0;
        int last = height.length - 1;
        int res = Integer.MIN_VALUE;

        while (first < last) {
            int area = Math.min(height[first], height[last]) * (last - first);
            res = Math.max(res, area);
            if (height[first] <= height[last])
                first++;
            else
                last--;
        }

        return res;
    }
}
