class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int temp = q.remove();
            q.add(-temp);
        }
        int sum = 0;
        for (int i : q) {
            sum += i;
        }
        return sum;
    }
}