class Solution {
    public int fun(int[] nums,int i,int[]dp){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+fun(nums,i+2,dp);
        int skip=fun(nums,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        // fun(nums,0,dp); dp
        // return dp[0];

        //tabulation
        if(nums.length==1)return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}