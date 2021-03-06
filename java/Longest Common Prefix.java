/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

/** MY
 采用纵向遍历的方式，遍历数组：
 index: 用于记录前面已经比较过的产生最短相同前缀的字符串的位置（在数组中的下标）；
 后面的字符串只用与此位置的字符串进行匹配；
 mostLen: 当前已经比较出来的最短前缀字符串的长度；
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";

        int len = strs.length;
        int index = 0;
        int mostLen = strs[0].length();
        for (int i = 1; i < len; i++) {
            int j = 0;
            while (j < strs[index].length() && j < strs[i].length()
                    && strs[index].charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (mostLen > j) {
                mostLen = j;
                index = i;
            }
        }

        return strs[index].substring(0, mostLen);
    }
}
