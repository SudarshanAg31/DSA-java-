class Solution {
    static int[] p;
    static int[] size;
    static boolean[] color;

    public int find(int a) {
        if (p[a] == a)
            return a;
        int led = find(p[a]);
        p[a] = led;
        return led;
    }

    public void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        if (a != b) {
            if (size[a] > size[b]) {
                p[b] = a;
                size[a] += size[b];
                color[j] = !color[i];
            } else {
                p[a] = b;
                size[b] += size[a];
                color[i] = !color[j];
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        p = new int[n];
        size = new int[n];
        color = new boolean[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
            color[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (i < graph[i][j]) {
                    if (find(i) == find(graph[i][j])) {
                        if (color[i] == color[graph[i][j]])
                            return false;
                    } else
                        union(i, graph[i][j]);
                }
            }
        }
        return true;
    }
}