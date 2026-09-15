class Solution {
    int total_max = 0;

    public void fun(int[][] grid, int i, int j, int max) {
        int n = grid.length;
        int m = grid[0].length;
        //up
        if (i - 1 >= 0 && grid[i - 1][j] != 0) {
            int temp = grid[i - 1][j];
            grid[i - 1][j] = 0;
            max += temp;
            fun(grid, i - 1, j, max);
            max -= temp;
            grid[i - 1][j] = temp;
        }
        //down
        if (i + 1 < n && grid[i + 1][j] != 0) {
            int temp = grid[i + 1][j];
            grid[i + 1][j] = 0;
            max += temp;
            fun(grid, i + 1, j, max);
            max -= temp;
            grid[i + 1][j] = temp;
        }
        //left
        if (j - 1 >= 0 && grid[i][j - 1] != 0) {
            int temp = grid[i][j - 1];
            grid[i][j - 1] = 0;
            max += temp;
            fun(grid, i, j - 1, max);
            max -= temp;
            grid[i][j - 1] = temp;
        }
        //right
        if (j + 1 < m && grid[i][j + 1] != 0) {
            int temp = grid[i][j + 1];
            grid[i][j + 1] = 0;
            max += temp;
            fun(grid, i, j + 1, max);
            max -= temp;
            grid[i][j + 1] = temp;
        }
        total_max = Math.max(total_max, max);
    }

    public int getMaximumGold(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    int temp = arr[i][j];
                    arr[i][j] = 0;
                    fun(arr, i, j, temp);
                    arr[i][j] = temp;
                }
            }
        }
        return total_max;
    }
}