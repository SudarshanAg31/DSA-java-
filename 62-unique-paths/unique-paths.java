class Solution {
    public int fun(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = 0;
        int down = 0;
        if (i < m - 1)
            right = fun(m, n, i + 1, j, dp);
        if (j < n - 1)
            down = fun(m, n, i, j + 1, dp);
        return dp[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(m, n, 0, 0, dp);
    }
}