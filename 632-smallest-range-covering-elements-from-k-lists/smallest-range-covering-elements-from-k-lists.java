class Solution {
    class Triplet implements Comparable<Triplet> {
        int ele, row, col;
        Triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Triplet t) {
            return this.ele - t.ele;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            pq.offer(new Triplet(val, i, 0));
        }
        int a = 0, b = Integer.MAX_VALUE;
        while (true) {
            Triplet top = pq.poll();
            if (max - top.ele < b - a) {
                a = top.ele;
                b = max;
            }
            if (top.col == nums.get(top.row).size() - 1)
                break;
            int next = nums.get(top.row).get(top.col + 1);
            max = Math.max(max, next);
            pq.offer(new Triplet(next, top.row, top.col + 1));
        }
        return new int[]{a, b};
    }
}