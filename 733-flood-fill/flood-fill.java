class Solution {
    class pair {
        int row;
        int col;

        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void fun(int[][] image, int sr, int sc, int color, boolean[][] vis) {
        int n = image.length;
        int m = image[0].length;
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(sr, sc));
        vis[sr][sc] = true;
        int color_temp = image[sr][sc];
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            pair temp = q.remove();
            int row = temp.row;
            int col = temp.col;
            //up
            if (row - 1 >= 0 && image[row - 1][col] == color_temp && !vis[row - 1][col]) {
                vis[row - 1][col] = true;
                image[row - 1][col] = color;
                q.add(new pair(row - 1, col));
            }
            //down
            if (row + 1 < n && image[row + 1][col] == color_temp && !vis[row + 1][col]) {
                vis[row + 1][col] = true;
                image[row + 1][col] = color;
                q.add(new pair(row + 1, col));
            }
            //left
            if (col - 1 >= 0 && image[row][col - 1] == color_temp && !vis[row][col - 1]) {
                vis[row][col - 1] = true;
                image[row][col - 1] = color;
                q.add(new pair(row, col - 1));
            }
            //right
            if (col + 1 < m && image[row][col + 1] == color_temp && !vis[row][col + 1]) {
                vis[row][col + 1] = true;
                image[row][col + 1] = color;
                q.add(new pair(row, col + 1));
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        fun(image, sr, sc, color, vis);
        return image;
    }
}