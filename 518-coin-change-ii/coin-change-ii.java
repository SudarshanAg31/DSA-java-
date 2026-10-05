class Solution {
    public int fun(int amount, int[] coin,int i,int[][]dp){
        if(amount==0){
            return 1;
        }
        if(i>=coin.length||amount<0)return 0;
        if(dp[amount][i]!=-1)return dp[amount][i];
        int take=fun(amount-coin[i],coin,i,dp);
        int skip=fun(amount,coin,i+1,dp);
        return dp[amount][i]=take+skip;
    }
    public int change(int amount, int[] coins) {
        int[][] dp=new int [amount+1][coins.length];
        for(int[] row:dp){
        Arrays.fill(row,-1);
        }
        return fun(amount,coins,0,dp);
    }
}