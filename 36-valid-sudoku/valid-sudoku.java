class Solution {
    public boolean check(char[][] board, int row, int col) {
        if (col == board.length) {
            row += 1;
            col = 0;
        }
        if (row == board.length) {
            return true;
        }
        int n = board.length;
        int i = row;
        int j = col;
        char ch = board[i][j];
        if (ch != '.') {
            //check row
            i = row;
            j = col;
            for (i = 0; i < board.length; i++) {
                if (i == row && j == col)
                    continue;
                else if (board[i][j] == ch)
                    return false;
            }
            //check col
            i = row;
            j = col;
            for (j = 0; j < board.length; j++) {
                if (i == row && j == col)
                    continue;
                else if (board[i][j] == ch)
                    return false;
            }
            //check 3X3
            i = row;
            j = col;
            i = i / 3;
            j = j / 3;
            i *= 3;
            j *= 3;
            int e = i + 3;
            int d = j + 3;
            for (int a = i; a < e; a++) {
                for (int b = j; b < d; b++) {
                    if (a == row && b == col)
                        continue;
                    if (board[a][b] == ch)
                        return false;
                }
            }
        }
        return check(board, row, col + 1);
    }

    public boolean isValidSudoku(char[][] board) {
        return check(board, 0, 0);
    }
}