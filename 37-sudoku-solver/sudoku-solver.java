class Solution {
    int check1 = 0;

    public boolean check(char[][] board, int row, int col, char ch) {
        int i = row;//0
        int j = col;//2
        //check row
        i = row;
        j = col;
        for (i = 0; i < board.length; i++) {
            if (board[i][j] == ch)
                return false;
        }
        //check col
        i = row;
        j = col;
        for (j = 0; j < board.length; j++) {
            if (board[i][j] == ch)
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
                if (board[a][b] == ch)
                    return false;
            }
        }
        return true;
    }

    public void fun(char[][] board, int row, int col) {
        if (col == board.length) {
            row += 1;
            col = 0;
        }
        if (row == board.length) {
            check1 = 1;
            return;
        }
        if (board[row][col] != '.') {
            fun(board, row, col + 1);
        } else {
            for (char i = '1'; i <= '9'; i++) {
                if (check(board, row, col, i)) {
                    board[row][col] = i;
                    fun(board, row, col + 1);
                    if (check1 != 1)
                        board[row][col] = '.';
                }
            }
        }
    }

    public void solveSudoku(char[][] board) {
        fun(board, 0, 0);
        check1 = 0;
    }
}