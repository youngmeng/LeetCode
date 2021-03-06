/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        if (p.length() == 0)
            return s.length() == 0;
        if (p.length() == 1)
            return s.length() == 1
                    && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));

        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2)))
                return true;
            return s.length() > 0
                    && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                    && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0
                    && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
                    && isMatch(s.substring(1), p.substring(1));
        }
    }
}
