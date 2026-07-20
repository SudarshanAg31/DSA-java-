class Solution {
    class custom implements Comparable<custom> {
        int s;
        int e;

        custom(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(custom a) {
            return Integer.compare(this.e, a.e);
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<custom> q = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            q.add(new custom(intervals[i][0], intervals[i][1]));
        }
        int str = Integer.MIN_VALUE;
        int ans = 0;
        while (!q.isEmpty()) {
            custom temp = q.remove();
            if (str <= temp.s) {
                str = temp.e;
            } else {
                ans++;
            }
        }
        return ans;
    }
}