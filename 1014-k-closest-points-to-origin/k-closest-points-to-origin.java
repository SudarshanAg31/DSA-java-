class Ans implements Comparable<Ans> {
    int dist;
    int x;
    int y;

    Ans(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Ans a) {
        return Integer.compare(this.dist, a.dist);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Ans> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < points.length; i++) {
    int x = points[i][0];
    int y = points[i][1];
    int dist = x * x + y * y;

    pq.add(new Ans(dist, x, y));

    if (pq.size() > k) {
        pq.poll();
    }
}

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Ans top = pq.poll();
            ans[i][0] = top.x;
            ans[i][1] = top.y;
        }

        return ans;
    }
}