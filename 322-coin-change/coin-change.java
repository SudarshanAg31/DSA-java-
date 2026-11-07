class Solution {
    public int fun(int[] coins, int amount, int i,int [][]dp) {
        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if(dp[amount][i]!=-1)return dp[amount][i];
        int take = Integer.MAX_VALUE / 2;
        int skip = Integer.MAX_VALUE / 2;
        if (coins[i] <= amount) {
            take = 1 + fun(coins, amount - coins[i], i,dp);
        }
        skip = fun(coins, amount, i + 1,dp);
        return dp[amount][i]=Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {
        int[][]dp=new int[amount+1][coins.length+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        int x=fun(coins, amount, 0, dp);
        return x==Integer.MAX_VALUE/2?-1:x;
    }
}