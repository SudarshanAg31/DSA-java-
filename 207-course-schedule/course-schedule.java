class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());
        int[] incoming = new int[n];
        for (int i = 0; i < pre.length; i++) {
            int a = pre[i][0], b = pre[i][1];
            arr.get(b).add(a);
            incoming[a]++;
        }
        List<Integer> store = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            store.add(x);
            for (Integer ele : arr.get(x)) {
                incoming[ele]--;
                if (incoming[ele] == 0) {
                    q.add(ele);
                }
            }
        }
        if (store.size() == n)
            return true;
        else
            return false;
    }
}