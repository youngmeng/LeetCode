/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;

        Arrays.sort(candidates);

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(candidates, target, 0, list, lists);

        return lists;
    }

    public void dfs(int[] nums, int target, int start,
                    List<Integer> list, List<List<Integer>> lists) {

        if (target == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        int previous = -1;
        for (int i = start; i < nums.length; i++) {
            if (previous == nums[i])
                continue;

            if (target < nums[i])
                return;

            previous = nums[i];

            list.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, list, lists);
            list.remove(list.size() - 1);
        }
    }
}
