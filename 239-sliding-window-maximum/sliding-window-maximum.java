class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        int x = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (i >= k - 1) {
                ans[x] = arr[q.peekFirst()];
                x++;
            }
        }
        return ans;
    }
}