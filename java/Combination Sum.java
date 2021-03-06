/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * <p>
 * 思路：使用 DFS 遍历
 */
/**
 思路：使用 DFS 遍历
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;

        Arrays.sort(candidates);//保持升序，算法有效

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(candidates, target, 0, list, lists);

        return lists;
    }

    public void dfs(int[] nums, int target, int start,
                    List<Integer> list, List<List<Integer>> lists) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(list));//此处必须新建ArrayList，否则49行remove时，会改变数据（因为引用还在）
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target < nums[i])
                return;

            list.add(nums[i]);
            dfs(nums, target - nums[i], i, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
