/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * <p>
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null && num2 == null)
            return null;
        if (num1 == null || num2 == null)
            return num1 == null ? num2 : num1;

        int len1 = num1.length();
        int len2 = num2.length();
        int[] mtly = new int[len1 + len2];

        for (int i = len1 - 1, offset1 = 0; i >= 0; i--, offset1++)
            for (int j = len2 - 1, offset2 = 0; j >= 0; j--, offset2++) {
                mtly[len1 + len2 - 1 - offset1 - offset2]
                        += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }

        int carray = 0;
        for (int k = len1 + len2 - 1; k >= 0; k--) {
            int val = mtly[k] + carray;
            mtly[k] = val % 10;
            carray = val / 10;
        }

        int m = 0;
        for (; m < mtly.length; m++) {
            if (mtly[m] != 0)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int n = m; n < mtly.length; n++) {
            sb.append(mtly[n]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
