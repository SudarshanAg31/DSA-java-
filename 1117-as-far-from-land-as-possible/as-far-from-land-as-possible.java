class Solution {
    class pair {
        int row;
        int col;

        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxDistance(int[][] grid) {
        int[][] vis = new int[grid.length][grid.length];
        Queue<pair> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new pair(i, j));
                } else {
                    vis[i][j] = -1;
                }
            }
        }
        int max = -1;
        while (!q.isEmpty()) {
            pair temp = q.remove();
            int i = temp.row;
            int j = temp.col;
            if (i - 1 >= 0 && vis[i - 1][j] == -1) {
                vis[i - 1][j] = vis[i][j] + 1;
                max = Math.max(max, vis[i - 1][j]);
                q.add(new pair(i - 1, j));
            }
            if (i + 1 < grid.length && vis[i + 1][j] == -1) {
                vis[i + 1][j] = vis[i][j] + 1;
                max = Math.max(max, vis[i + 1][j]);
                q.add(new pair(i + 1, j));
            }
            if (j - 1 >= 0 && vis[i][j - 1] == -1) {
                vis[i][j - 1] = vis[i][j] + 1;
                max = Math.max(max, vis[i][j - 1]);
                q.add(new pair(i, j - 1));
            }
            if (j + 1 < grid.length && vis[i][j + 1] == -1) {
                vis[i][j + 1] = vis[i][j] + 1;
                max = Math.max(max, vis[i][j + 1]);
                q.add(new pair(i, j + 1));
            }
        }
        return max;
    }
}