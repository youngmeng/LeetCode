/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * For example,
 * Given s = "Hello World",
 * return 5.
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int len = s.length();
        int i = len - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                break;
        }

        if (i < 0) return 0;

        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) == ' ')
                return i - j;
        }

        return i + 1;
    }
}
