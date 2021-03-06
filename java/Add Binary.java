/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */

public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int ia = 0;
        int jb = 0;
        int carry = 0;
        StringBuilder ret = new StringBuilder();

        while (i >= 0 && j >= 0) {
            ia = a.charAt(i--) == '0' ? 0 : 1;
            jb = b.charAt(j--) == '0' ? 0 : 1;
            int d = ia + jb + carry;
            ret.append(d % 2 == 0 ? '0' : '1');
            carry = d / 2;
        }

        if (i >= 0) {
            while (i >= 0) {
                ia = a.charAt(i--) == '0' ? 0 : 1;
                int d = ia + carry;
                ret.append(d % 2 == 0 ? '0' : '1');
                carry = d / 2;
            }
        } else if (j >= 0) {
            while (j >= 0) {
                jb = b.charAt(j--) == '0' ? 0 : 1;
                int d = jb + carry;
                ret.append(d % 2 == 0 ? '0' : '1');
                carry = d / 2;
            }
        }

        if (carry == 1)
            ret.append('1');

        return ret.reverse().toString();
    }
}
