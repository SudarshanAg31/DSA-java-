class Solution {
    class custom implements Comparable<custom> {
        int i;
        int s;
        int e;

        custom(int i, int s, int e) {
            this.i = i;
            this.s = s;
            this.e = e;
        }

        public int compareTo(custom a) {
            return Integer.compare(this.s, a.s);
        }
    }

    class heap implements Comparable<heap> {
        int i;
        int e;

        heap(int i, int e) {
            this.i = i;
            this.e = e;
        }

        public int compareTo(heap a) {
            if (this.e != a.e)
                return Integer.compare(this.e, a.e);
            return Integer.compare(this.i, a.i);
        }
    }

    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        List<custom> arr = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            arr.add(new custom(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(arr);
        int time = arr.get(0).s;
        PriorityQueue<heap> q = new PriorityQueue<>();
        q.add(new heap(arr.get(0).i, arr.get(0).e));
        int w = 1;
        int r = 0;
        while (w < tasks.length) {
            while (w < tasks.length && time >= arr.get(w).s) {
                custom temp = arr.get(w);
                q.add(new heap(temp.i, temp.e));
                w++;
            }
            if (!q.isEmpty()) {
                heap temp = q.remove();
                time += temp.e;
                ans[r++] = temp.i;
            } else {
                custom temp = arr.get(w);
                time = temp.s;
                q.add(new heap(temp.i, temp.e));
                w++;
            }
        }
        while (!q.isEmpty()) {
            heap temp = q.remove();
            ans[r++] = temp.i;
        }
        return ans;
    }
}