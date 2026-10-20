class pair {
    int i;
    int j;

    pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int bfs(int a, int b, int[][] grid, boolean[][] vis) {
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(a, b));
        int count = 0;
        while (!q.isEmpty()) {
            pair temp = q.remove();
            int i=temp.i;
            int j=temp.j;
            if (!vis[i][j]) {
                vis[i][j] = true;
                //up
                if (i - 1 >= 0 && grid[i - 1][j] == 1 && !vis[i - 1][j]) {
                    q.add(new pair(i - 1, j));
                }
                //down
                if (i + 1 < grid.length && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
                    q.add(new pair(i + 1, j));
                }
                //left
                if (j - 1 >= 0 && grid[i][j - 1] == 1 && !vis[i][j - 1]) {
                    q.add(new pair(i, j - 1));
                }
                //right
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && !vis[i][j + 1]) {
                    q.add(new pair(i, j + 1));
                }
            count++;
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    int val = bfs(i, j, grid, vis);
                    max = Math.max(val, max);
                }
            }
        }
        return max;
    }
}