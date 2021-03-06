/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p>
 * 思路：要用O(n)的复杂度实现
 * 栈中保存的不是'('而是'('所在的下标
 */
/**
 思路：要用O(n)的复杂度实现
 栈中保存的不是'('而是'('所在的下标
 */

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;

        int maxcnt = 0;
        int index = -1;
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    index = i;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        maxcnt = Math.max(maxcnt, i - index);
                    } else {
                        maxcnt = Math.max(maxcnt, i - stack.peek());
                    }
                }
            }
        }

        return maxcnt;
    }
}
