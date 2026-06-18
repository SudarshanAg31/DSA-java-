class Solution {
    public void dfs(List<List<Integer>> ans, boolean[] check, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int ele : ans.get(x)) {
                if (!check[ele]) {
                    q.add(ele);
                    check[ele] = true;
                }
                if (check[end])
                    return;
            }
        }
    }

    public boolean validPath(int n, int[][] arr, int start, int end) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
        }
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0], b = arr[i][1];
            ans.get(a).add(b);
            ans.get(b).add(a);
        }
        boolean[] check = new boolean[n];
        dfs(ans, check, start, end);
        return check[end];
    }
}