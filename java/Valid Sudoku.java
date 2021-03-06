/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;

        boolean[] used = new boolean[9];

        for (int i = 0; i < 9; i++) {
            reset(used);

            //检查行
            for (int j = 0; j < 9; j++)
                if (!check(used, board[i][j]))
                    return false;

            reset(used);

            //检查列
            for (int j = 0; j < 9; j++)
                if (!check(used, board[j][i]))
                    return false;
        }

        //检查九宫格
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                reset(used);

                for (int i = row * 3; i < row * 3 + 3; i++) {
                    for (int j = column * 3; j < column * 3 + 3; j++) {
                        if (!check(used, board[i][j]))
                            return false;
                    }
                }
            }
        }

        return true;
    }

    //将boolean数组重置
    public void reset(boolean[] used) {
        for (int i = 0; i < used.length; i++)
            used[i] = false;
    }

    //检查状态：如果某个数字已经被用，返回false；否则，返回true
    public boolean check(boolean[] used, char ch) {
        if (ch == '.')
            return true;
        if (used[ch - '1'])
            return false;

        used[ch - '1'] = true;
        return true;
    }
}
