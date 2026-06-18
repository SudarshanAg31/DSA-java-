class Solution {
    public int bfs(int[][] arr, boolean[] check) {
        int n = arr.length;
        int z = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!check[i + 1]) {
                q.add(i + 1);
                check[i + 1] = true;
                while (!q.isEmpty()) {
                    int x = q.remove();
                    for (int j = 0; j < n; j++) {
                        if (arr[x - 1][j] == 1 && !check[j + 1]) {
                            q.add(j + 1);
                            check[j + 1] = true;
                        }
                    }
                }
                z++;
            }
        }
        return z;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] check = new boolean[n + 1];
        int ans = bfs(isConnected, check);
        return ans;

    }
}