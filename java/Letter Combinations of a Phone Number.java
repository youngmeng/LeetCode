/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters just like on the telephone buttons.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

/**
 采用深度搜索遍历
 */

public class Solution {

    String[] mapping = {" ", "", "abc", "def", "ghi",//0 1 2 3 4
            "jkl", "mno", "pqrs", "tuv", "wxyz"};//5 6 7 8 9

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();

        if (digits == null) return null;
        if (digits.length() == 0) return list;

        dfs(list, 0, digits, "");
        return list;
    }

    public void dfs(List<String> list, int index, String str, String path) {
        if (index == str.length()) {
            list.add(path);
            return;
        }
        String string = mapping[str.charAt(index) - '0'];
        for (int j = 0; j < string.length(); j++) {
            dfs(list, index + 1, str, path + string.charAt(j));
        }
    }
}
