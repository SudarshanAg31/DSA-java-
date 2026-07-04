class Solution {
    public int fun(int i,List<Integer> arr, int tg,int [][]dp){
        if(i==arr.size()){
            if(tg==0)return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[i][tg]!=-1)return dp[i][tg];
        int skip=fun(i+1,arr,tg,dp);
        if(tg-arr.get(i)<0)return dp[i][tg]=skip;
        int take=1+fun(i+1,arr,tg-arr.get(i),dp);
        return dp[i][tg]=Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int [][]dp=new int [nums.size()][target+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        int ans=fun(0,nums,target,dp);
        if(ans<0)return -1;
        return ans;
    }
}