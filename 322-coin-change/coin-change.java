class Solution {
    public long fun(int i, int c, int[] coins, long[][] dp) {
        if (i == coins.length) {
            if (c == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        if (dp[i][c] != -1)
            return dp[i][c];
        long skip = fun(i + 1, c, coins, dp);
        if (c - coins[i] < 0)
            return skip;
        long take = 1 + fun(i, c - coins[i], coins, dp);
        return dp[i][c] = Math.min(skip, take);
    }

    public int coinChange(int[] coins, int amount) {
        long[][] dp = new long[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int) fun(0, amount, coins, dp);
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
}