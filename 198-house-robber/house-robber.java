class Solution {
    public int fun(int[] nums,int i,int[] dp){
        if(i==nums.length){
            return 0;
        }
        if(i>nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+fun(nums,i+2,dp);
        int skip=fun(nums,i+1,dp);
        return dp[i]=Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
       return fun(nums,0,dp); 
    }
}