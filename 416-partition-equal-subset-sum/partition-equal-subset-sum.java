class Solution {
    public boolean fun(int i, int j, int[] nums, int cp, int[][] dp) {
        if (j == cp)
            return true;
        if (i == nums.length)
            return false;
        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        boolean skip = fun(i + 1, j, nums, cp, dp);
        boolean ans = false;
        if (j + nums[i] > cp)
            ans = skip;
        else {
            boolean take = fun(i + 1, j + nums[i], nums, cp, dp);
            ans = skip || take;
        }
        dp[i][j] = (ans) ? 1 : 0;
        return ans;
    }

    public boolean canPartition(int[] nums) {
        int cp = 0;
        for (int i = 0; i < nums.length; i++) {
            cp += nums[i];
        }
        if (cp % 2 == 0) {
            int[][] dp = new int[nums.length][cp + 1];
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < cp + 1; j++) {
                    dp[i][j] = -1;
                }
            }
            return fun(0, 0, nums, cp / 2, dp);
        } else {
            return false;
        }
    }
}