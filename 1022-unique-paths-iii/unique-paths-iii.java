class Solution {
    static int count;

    public void fun(int[][] grid, int i, int j, int block) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[i][j] == 2) {
            if (block == 0)
                count++;
            return;
        }
        if (i - 1 >= 0 && (grid[i - 1][j] == 0 || grid[i - 1][j] == 2)) {
            if (grid[i - 1][j] == 0) {
                grid[i - 1][j] = -1;
                fun(grid, i - 1, j, block - 1);
                grid[i - 1][j] = 0;
            } else
                fun(grid, i - 1, j, block);
        }
        // DOWN
        if (i + 1 < n && (grid[i + 1][j] == 0 || grid[i + 1][j] == 2)) {
            if (grid[i + 1][j] == 0) {
                grid[i + 1][j] = -1;
                fun(grid, i + 1, j, block - 1);
                grid[i + 1][j] = 0;
            } else
                fun(grid, i + 1, j, block);
        }
        // LEFT
        if (j - 1 >= 0 && (grid[i][j - 1] == 0 || grid[i][j - 1] == 2)) {
            if (grid[i][j - 1] == 0) {
                grid[i][j - 1] = -1;
                fun(grid, i, j - 1, block - 1);
                grid[i][j - 1] = 0;
            } else
                fun(grid, i, j - 1, block);

        }
        // RIGHT
        if (j + 1 < m && (grid[i][j + 1] == 0 || grid[i][j + 1] == 2)) {
            if (grid[i][j + 1] == 0) {
                grid[i][j + 1] = -1;
                fun(grid, i, j + 1, block - 1);
                grid[i][j + 1] = 0;
            } else
                fun(grid, i, j + 1, block);

        }
    }

    public int uniquePathsIII(int[][] grid) {
        count = 0;
        int s = 0;
        int e = 0;
        int block = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    s = i;
                    e = j;
                } else if (grid[i][j] == 0) {
                    block++;
                }
            }
        }
        fun(grid, s, e, block);
        return count;
    }
}