class pair implements Comparable<pair> {
    int n;
    double pro;

    pair(int n, double pro) {
        this.n = n;
        this.pro = pro;
    }

    @Override
    public int compareTo(pair d) {
        return Double.compare(this.pro, d.pro);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<pair>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<pair>());
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            arr.get(a).add(new pair(b, succProb[i]));
            arr.get(b).add(new pair(a, succProb[i]));
        }
        double[] ans = new double[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        ans[start] = 1.0;
        PriorityQueue<pair> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(new pair(start, 1.0));
        while (!q.isEmpty()) {
            pair top = q.remove();
            int node = top.n;
            double prob = top.pro;
            if (ans[node] > prob)
                continue;
            for (pair ele : arr.get(node)) {
                pair uniq = ele;
                int a = uniq.n;
                double b = uniq.pro;
                if (ans[a] < prob * b) {
                    ans[a] = prob * b;
                    q.add(new pair(a, ans[a]));
                }
            }
        }
        return ans[end] != Integer.MIN_VALUE ? ans[end] : 0.0;
    }
}