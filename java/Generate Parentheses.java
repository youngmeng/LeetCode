/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if (n <= 0) return list;

        dfs(list, "", n, n);
        return list;
    }

    public void dfs(List<String> list, String str, int left, int right) {
        if (left > right) return;//左括号少于右括号时，不配对，退出

        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }

        if (left > 0) {
            dfs(list, str + '(', left - 1, right);
        }
        if (right > 0) {
            dfs(list, str + ')', left, right - 1);
        }
    }
}
