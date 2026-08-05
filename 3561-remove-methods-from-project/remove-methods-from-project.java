class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] indeg = new int[n];
        boolean[] check = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < invocations.length; i++) {
            int a = invocations[i][0], b = invocations[i][1];
            adj.get(a).add(b);
            indeg[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        check[k] = true;
        while (!q.isEmpty()) {
            int temp = q.remove();
            for (int i : adj.get(temp)) {
                indeg[i]--;
                if (!check[i]) {
                    check[i] = true;
                    q.add(i);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        boolean last_check = false;
        for (int i = 0; i < n; i++) {
            if (check[i] && indeg[i] != 0) {
                last_check = true;
                break;
            }
        }
        if (last_check) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i])
                    ans.add(i);
            }
        }
        return ans;
    }
}