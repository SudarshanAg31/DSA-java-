class Solution {
    public long fun(int[] prices, int i, int buy, int k, long[][][] dp) {
        if (k == -1)
            return 0;
        if (i == prices.length) {
            if (buy == 1 && k % 2 == 0)
                return Long.MIN_VALUE / 4;
            return 0;
        }
        if (dp[i][buy][k] != -1)
            return dp[i][buy][k];
        if (buy == 0 && k % 2 == 0) {
            long x = prices[i] + fun(prices, i + 1, 1, k - 1, dp);
            long y = fun(prices, i + 1, 0, k, dp);
            return dp[i][buy][k] = Math.max(x, y);
        }
        if (buy == 1 && k % 2 == 1) {
            long x = -prices[i] + fun(prices, i + 1, 0, k - 1, dp);
            long y = +prices[i] + fun(prices, i + 1, 1, k - 1, dp);
            long z = fun(prices, i + 1, 1, k, dp);
            return dp[i][buy][k] = Math.max(x, Math.max(y, z));
        } else {
            long x = -prices[i] + fun(prices, i + 1, 1, k - 1, dp);
            long y = fun(prices, i + 1, 1, k, dp);
            return dp[i][buy][k] = Math.max(x, y);
        }
    }

    public long maximumProfit(int[] prices, int k) {
        long[][][] dp = new long[prices.length + 1][2][2 * k];
        for (long[][] row : dp) {
            for (long[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return fun(prices, 0, 1, 2 * k - 1, dp);
    }
}