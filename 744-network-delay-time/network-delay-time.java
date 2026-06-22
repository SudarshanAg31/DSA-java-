class pair implements Comparable<pair> {
    int n;
    int dis;

    pair(int n, int dis) {
        this.n = n;
        this.dis = dis;
    }

    public int compareTo(pair d) {
        return this.dis - d.dis;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> arr = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++)
            arr.add(new ArrayList<pair>());
        for (int i = 0; i < times.length; i++) {
            int a = times[i][0];
            int b = times[i][1];
            int c = times[i][2];
            arr.get(a).add(new pair(b, c));
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        PriorityQueue<pair> p = new PriorityQueue<>();
        p.add(new pair(k, 0));
        while (!p.isEmpty()) {
            pair top = p.remove();
            int nd = top.n;
            int di = top.dis;
            for (pair ele : arr.get(nd)) {
                pair uniq = ele;
                int a = uniq.n;
                int b = uniq.dis;
                if (ans[nd] < di) {
                    continue;
                }
                if (ans[a] > di + b) {
                    ans[a] = di + b;
                    p.add(new pair(a, ans[a]));
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, ans[i]);
        }
        return max;
    }
}