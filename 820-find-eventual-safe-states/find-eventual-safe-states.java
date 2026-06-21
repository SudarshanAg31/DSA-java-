class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < graph.length; i++)
            arr.add(new ArrayList<>());
        int[] indegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int ele : graph[i]) {
                arr.get(ele).add(i);
                indegree[i]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            ans.add(x);
            for (int ele : arr.get(x)) {
                indegree[ele]--;
                if (indegree[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}