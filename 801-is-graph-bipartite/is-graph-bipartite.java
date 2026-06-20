class Solution {
    public void bfs(int i, int[][] graph, int[] check) {
        Queue<Integer> q = new LinkedList<>();
        check[i] = 0;
        q.add(i);
        while (!q.isEmpty()) {
            int x = q.remove();
            int color = check[x];
            for (int ele : graph[x]) {
                if (check[ele] == check[x]) {
                    ans = false;
                    return;
                }
                if (check[ele] == -1) {
                    check[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
    }

    static boolean ans;

    public boolean isBipartite(int[][] graph) {
        ans = true;
        int[] check = new int[graph.length];
        Arrays.fill(check, -1);
        for (int i = 0; i < graph.length; i++) {
            if (check[i] == -1)
                bfs(i, graph, check);
        }
        return ans;
    }
}