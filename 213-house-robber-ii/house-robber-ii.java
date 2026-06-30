class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int dp[] = new int[n];
        int dp1[] = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        return Math.max(fun(nums, dp, 0, n - 2), fun(nums, dp1, 1, n - 1));
    }

    public int fun(int[] nums, int[] dp, int i, int end) {
        if (i > end)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int take = nums[i] + fun(nums, dp, i + 2, end);
        int skip = fun(nums, dp, i + 1, end);
        return dp[i] = Math.max(take, skip);
    }
}