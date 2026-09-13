class Solution {
    public long countPairs(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        long pair = 0;
        int remaining = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (!vis[i]) {
                q.add(i);
                vis[i] = true;
                count = 1;
            }
            while (!q.isEmpty()) {
                int temp = q.remove();
                for (int j : adj.get(temp)) {
                    if (!vis[j]) {
                        count++;
                        vis[j] = true;
                        q.add(j);
                    }
                }
            }
            remaining -= count;
            pair += (long) count * remaining;
        }
        return pair;
    }
}