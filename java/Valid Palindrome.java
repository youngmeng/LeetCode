/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char left_char = s.charAt(left);
            char right_char = s.charAt(right);

            if (!isAlphabet(left_char)) {
                left++;
            } else if (!isAlphabet(right_char)) {
                right--;
            } else if (left_char == right_char || Math.abs(left_char - right_char) == 32) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphabet(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
