class trip implements Comparable<trip> {
    int p;
    int c;
    int dis;

    trip(int p, int c, int dis) {
        this.p = p;
        this.c = c;
        this.dis = dis;
    }

    public int compareTo(trip d) {
        return this.dis - d.dis;
    }
}

class Solution {
    static int size[];
    static int pa[];

    public int find(int a) {
        if (pa[a] == a)
            return a;
        int led = find(pa[a]);
        pa[a] = led;
        return led;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (size[a] > size[b]) {
                pa[b] = a;
                size[a] += size[b];
            } else {
                pa[a] = b;
                size[b] += size[a];
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<trip> q = new PriorityQueue<>();
        pa=new int [n];
        size=new int [n];
        for (int i = 0; i < n; i++) {
            pa[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int x = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                q.add(new trip(i, j, x));
            }
        }
        int cost = 0;
        while (!q.isEmpty()) {
            trip top = q.remove();
            int a = top.p;
            int c = top.c;
            int dis = top.dis;
            a = find(a);
            c = find(c);
            if (a != c) {
                cost += dis;
                union(a, c);
            }
        }
        return cost;
    }
}