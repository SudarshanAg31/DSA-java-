import java.util.*;
class Solution {
    int[][][] dp;
    public int fun(int[][] grid, int i, int j, int i1, int j1) {
        int m = grid[0].length;
        if(j < 0 || j1 < 0 || j >= m || j1 >= m)
            return Integer.MIN_VALUE / 2;
        if(i == grid.length - 1) {
            if(j == j1) {
                return grid[i][j];
            }
            return grid[i][j] + grid[i1][j1];
        }
        if(dp[i][j][j1] != -1) return dp[i][j][j1];
        int temp = grid[i][j];
        int temp1 = 0;
        if(j != j1) {
            temp1 = grid[i1][j1];
        }
        int down = fun(grid, i+1, j, i1+1, j1);
        int right = fun(grid, i+1, j-1, i1+1, j1);
        int left = fun(grid, i+1, j+1, i1+1, j1);

        int fdown = fun(grid, i+1, j, i1+1, j1-1);
        int fright = fun(grid, i+1, j-1, i1+1, j1-1);
        int fleft = fun(grid, i+1, j+1, i1+1, j1-1);

        int x = fun(grid, i+1, j, i1+1, j1+1);
        int y = fun(grid, i+1, j-1, i1+1, j1+1);
        int z = fun(grid, i+1, j+1, i1+1, j1+1);   
        int ans = Math.max(down, Math.max(right, left));
        int ans1 = Math.max(fdown, Math.max(fright, fleft));
        int ans2 = Math.max(x, Math.max(y,z));
        return dp[i][j][j1] = temp + temp1 + Math.max(ans,Math.max(ans1, ans2));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m][m];
        for(int[][] a : dp)
            for(int[] b : a)
                Arrays.fill(b, -1);

        return fun(grid, 0, 0, 0, m - 1);
    }
}