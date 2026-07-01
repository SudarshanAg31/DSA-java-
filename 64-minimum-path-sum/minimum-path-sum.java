class Solution {
    public int fun(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if (i < m - 1)
            right = fun(grid, m, n, i + 1, j, dp);
        if (j < n - 1)
            down = fun(grid, m, n, i, j + 1, dp);
        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(grid, m, n, 0, 0, dp);
    }
}