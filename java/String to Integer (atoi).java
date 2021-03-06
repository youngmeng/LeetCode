/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * <p>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        long num = 0;
        char[] array = str.toCharArray();
        int left = 0;

        while (array[left] == ' ') {
            left++;
        }

        if (left >= array.length) {
            return 0;
        }

        boolean minus = false;
        if (array[left] == '+') {
            left++;
        } else if (array[left] == '-') {
            left++;
            minus = true;
        }

        if (left < array.length) {
            num = atoiHelper(array, left, array.length - 1, minus);
        }

        return (int) num;
    }

    public long atoiHelper(char[] arr, int left, int right, boolean minus) {
        long num = 0;
        int i = left;
        int flag = minus ? -1 : 1;
        while (i <= right) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num = num * 10 + flag * (arr[i] - '0');

                if (num > 0x7fffffff) {
                    return Integer.MAX_VALUE;
                }
                if (num < 0x80000000) {
                    return Integer.MIN_VALUE;
                }

                i++;
            } else {
                break;
            }
        }
        return num;
    }
}
