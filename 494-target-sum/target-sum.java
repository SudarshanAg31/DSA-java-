class Solution {
    static int sum;

    public int fun(int i, int[] nums, int res, int target, int[][] dp) {
        if (i == nums.length) {
            if (target == res)
                return 1;
            else
                return 0;
        }
        if (dp[i][res + sum] != -1)
            return dp[i][res + sum];
        int skip = fun(i + 1, nums, res + nums[i], target, dp);
        int take = fun(i + 1, nums, res - nums[i], target, dp);
        return dp[i][sum + res] = skip + take;
    }

    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        //sum*2 ker ne ka reason ek hai ki -ve ko bhi le n hai jo bhi possible hai -sum to +Sum tak sum+res kyu ke index -ve nhi hota
        for (int ele : nums)
            sum += ele;
        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, nums, 0, target, dp);
    }
}