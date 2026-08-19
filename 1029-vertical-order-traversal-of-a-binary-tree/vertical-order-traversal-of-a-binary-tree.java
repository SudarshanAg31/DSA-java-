class Solution {
    class custom implements Comparable<custom> {
        int col;
        int val;

        custom(int col, int val) {
            this.col = col;
            this.val = val;
        }

        public int compareTo(custom a) {
            return Integer.compare(this.val, a.val);
        }
    }

    class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        Queue<custom> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair curr = q.remove();
                TreeNode temp = curr.node;
                int curr_col = curr.col;
                pq.add(new custom(curr_col, temp.val));
                if (temp.left != null) {
                    q.add(new Pair(temp.left, curr_col - 1));
                }
                if (temp.right != null) {
                    q.add(new Pair(temp.right, curr_col + 1));
                }
            }
            while (!pq.isEmpty()) {
                custom sort = pq.remove();
                if (!mp.containsKey(sort.col)) {
                    ArrayList<Integer> nums = new ArrayList<>();
                    nums.add(sort.val);
                    mp.put(sort.col, nums);
                } else {
                    mp.get(sort.col).add(sort.val);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : mp.keySet()) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        while (min <= max) {
            ans.add(mp.get(min));
            min++;
        }
        return ans;
    }
}