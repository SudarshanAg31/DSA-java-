class Solution {
    public boolean fun(int[][]grid,int i,int j){
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1; // mark as visited
        boolean left = fun(grid,i, j-1), right = fun(grid,i, j+1);
        boolean up = fun(grid,i-1, j), down = fun(grid,i+1, j);
        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 || i != grid.length || j != 0 || j != grid[0].length) {
                    if (grid[i][j] == 0 &&fun(grid,i,j) ){
                       count++;
                    }
                }
                else{
                    grid[i][j]=1;
                }
            }
        }
        return count;
    }
}