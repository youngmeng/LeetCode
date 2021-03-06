/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

/**
 字符串匹配，返回第一次匹配成功的首元素的位置
 思路：高效算法有KMP，这里暴力匹配也可通过
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 == 0 && len2 == 0)
            return 0;

        for (int i = 0; i < len1; i++) {
            int a = i;
            int b = 0;
            while (b < len2) {
                if (a >= len1 || haystack.charAt(a) != needle.charAt(b)) {
                    break;
                } else {
                    a++;
                    b++;
                }
            }
            if (b == len2)
                return i;
        }

        return -1;
    }
}
