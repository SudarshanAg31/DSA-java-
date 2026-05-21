class Solution {
    int ans = 0;

    public int totalNQueens(int n) {
        ans = 0;
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 'X';
            }
        }
        fun(arr, 0);
        return ans;
    }

    private void fun(char[][] arr, int row) {
        int n = arr.length;
        if (n == row) {
            ans++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (issafe(arr, row, j)) {
                arr[row][j] = 'Q';
                fun(arr, row + 1);
                arr[row][j] = 'X';
            }
        }
    }

    private boolean issafe(char[][] arr, int row, int col) {
        int n = arr.length;
        int i = row;
        int j = col;
        //col check ker re ge
        for (j = 0; j < n; j++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        i = row;
        j = col;
        //row check ker re ge
        for (i = 0; i < n; i++) {
            if (arr[i][j] == 'Q')
                return false;
        }
        i = row;
        j = col;
        //upper left
        while (i >= 0 && j >= 0) {
            if (arr[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        //lower right
        while (i < n && j < n) {
            if (arr[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = row;
        j = col;
        //upper right
        while (i >= 0 && j < n) {
            if (arr[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        //lower left
        while (i < n && j >= 0) {
            if (arr[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        return true;
    }
}