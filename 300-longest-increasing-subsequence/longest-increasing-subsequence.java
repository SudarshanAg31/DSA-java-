class Solution {
    public int fun(int[] nums, int i, int prev,int[][]dp) {
        if (i == nums.length) {
            return 0;
        }
        if(dp[i][prev+1]!=-2)return dp[i][prev+1];
        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + fun(nums, i + 1, i,dp);
        }
        int skip = fun(nums, i + 1, prev,dp);
        return dp[i][prev+1]=Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int [nums.length+1][nums.length+1];
        for(int []row :dp){
            Arrays.fill(row,-2);
        }
        return fun(nums, 0, -1,dp);
    }
}