/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 */

/**
 思路：1.遍历每个点，当是空白('.')时，就填数；
 2.填数从1到9逐个尝试，当有效时且填过后的数独有效时，返回true。（DFS）
 3.定义检查函数：检查填的数是否有效
 */

public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuIsValid(board);
    }

    //主函数，填充数字：DFS
    public boolean solveSudokuIsValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        board[i][j] = (char) (48 + k);
                        if (isValid(board, i, j) && solveSudokuIsValid(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //检查board(x,y)是否有效
    public boolean isValid(char[][] board, int x, int y) {
        int i = 0;
        int j = 0;

        //检查x行是否有效
        for (i = 0; i < 9; i++) {
            if (i != y && board[x][i] == board[x][y])
                return false;
        }

        //检查y列是否有效
        for (j = 0; j < 9; j++) {
            if (j != x && board[j][y] == board[x][y])
                return false;
        }

        //检查(x,y)所在九宫格
        for (i = 3 * (x / 3); i < 3 * (x / 3 + 1); i++) {
            for (j = 3 * (y / 3); j < 3 * (y / 3 + 1); j++) {
                if (i != x && j != y && board[i][j] == board[x][y])
                    return false;
            }
        }

        return true;
    }
}
