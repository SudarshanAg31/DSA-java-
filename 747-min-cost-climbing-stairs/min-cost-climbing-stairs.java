class Solution {
    public int fun(int[] min,int i,int []dp){
        if(i==1||i==0)return min[i];
        if(dp[i]!=-1)return dp[i];
        return dp[i]=min[i]+Math.min(fun(min,i-1,dp),fun(min,i-2,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int []dp=new int[cost.length];
        Arrays.fill(dp,-1);
       return Math.min(fun(cost,cost.length-1,dp),fun(cost,cost.length-2,dp));
    }
}