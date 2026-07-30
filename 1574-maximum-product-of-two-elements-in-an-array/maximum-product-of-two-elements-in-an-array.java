class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (1 < i) {
                q.remove();
            }
        }
        int a = q.remove();
        int b = q.remove();
        return (a - 1) * (b - 1);
    }
}