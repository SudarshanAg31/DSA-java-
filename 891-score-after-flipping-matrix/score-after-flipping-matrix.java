class Solution {
    public void reverse(int[][] grid, int i) {
        for (int j = 0; j < grid[0].length; j++) {
            grid[i][j] ^= 1;
        }
    }

    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                reverse(grid, i);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0)
                    count++;
            }
            if (count > grid.length / 2) {
                for (int i = 0; i < grid.length; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int sum = 0;
        int pow = 1;
        for (int j = grid[0].length - 1; j >= 0; j--) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1)
                    count++;
            }
            sum += count * pow;
            pow *= 2;
        }
        return sum;
    }
}