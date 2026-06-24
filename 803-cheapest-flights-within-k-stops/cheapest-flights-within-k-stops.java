class trip implements Comparable<trip> {
    int n;
    int c;
    int st;

    trip(int n, int c, int st) {
        this.n = n;
        this.c = c;
        this.st = st;
    }

    public int compareTo(trip d) {
        return this.st - d.st;
    }
}

class pair {
    int n;
    int c;

    pair(int n, int c) {
        this.n = n;
        this.c = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<pair>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<pair>());
        for (int i = 0; i < flights.length; i++) {
            int a = flights[i][0], b = flights[i][1], c = flights[i][2];
            arr.get(a).add(new pair(b, c));
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<trip> q = new PriorityQueue<>();
        q.add(new trip(src, 0, 0));
        while (!q.isEmpty()) {
            trip top = q.remove();
            int node = top.n;
            int c = top.c;
            int st = top.st;
            if (st - 1 == k && node == dst) {
                return ans[dst];
            } else if (st - 1 == k && node != dst) {
                continue;
            } else {
                for (pair ele : arr.get(node)) {
                    int nd = ele.n;
                    int cost = ele.c;
                    if (cost + c < ans[nd]) {
                        ans[nd] = cost + c;
                        q.add(new trip(nd, ans[nd], st + 1));
                    }
                }
            }
        }
        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
}