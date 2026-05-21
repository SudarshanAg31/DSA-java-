class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        return isvalid(grid, 0, 0, 0);
    }

    private static boolean isvalid(int[][] grid, int no, int row, int col) {
        int n = grid.length;
        int size = grid.length * grid.length;
        if (no == size - 1) {
            return true;
        }
        int i = row;
        int j = col;
        //2 up 1 right
        i -= 2;
        j += 1;
        if (i >= 0 && j < n && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 up 1 left
        i -= 2;
        j -= 1;
        if (i >= 0 && j >= 0 && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 left 1 up
        i -= 1;
        j -= 2;
        if (i >= 0 && j >= 0 && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 left 1 down
        i += 1;
        j -= 2;
        if (i < n && j >= 0 && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 lower 1 right
        i += 2;
        j += 1;
        if (i < n && j < n && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 lower 1 left
        i += 2;
        j -= 1;
        if (i < n && j >= 0 && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 right 1 up
        i -= 1;
        j += 2;
        if (i >= 0 && j < n && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        i = row;
        j = col;
        //2 right 1 down
        i += 1;
        j += 2;
        if (i < n && j < n && grid[i][j] == no + 1)
            return isvalid(grid, no + 1, i, j);
        return false;
    }
}