class Solution {
    public int fun(int[] prices, int i, int buy, int count, int[][][] dp) {
        if (i == prices.length)
            return 0;
        if (count == 0)
            return 0;
        if (dp[i][buy][count] != -1)
            return dp[i][buy][count];
        if (buy == 1) {
            int x = -prices[i] + fun(prices, i + 1, 0, count - 1, dp);
            int y = fun(prices, i + 1, 1, count, dp);
            return dp[i][buy][count] = Math.max(x, y);
        } else {
            int x = prices[i] + fun(prices, i + 1, 1, count - 1, dp);
            int y = fun(prices, i + 1, 0, count, dp);
            return dp[i][buy][count] = Math.max(x, y);
        }
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k * 2 + 1];
        // for (int[][] two : dp) {
        //     for (int[] row : two) {
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return fun(prices,0,1,k*2,dp);
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int l = 1; l < k * 2 + 1; l++) {
                    if (j == 1) {
                        int x = -prices[i] + dp[i + 1][0][l - 1];
                        int y = dp[i + 1][1][l];
                        dp[i][j][l] = Math.max(x, y);
                    } else {
                        int x = prices[i] + dp[i + 1][1][l - 1];
                        int y = dp[i + 1][0][l];
                        dp[i][j][l] = Math.max(x, y);
                    }
                }
            }
        }
        return dp[0][1][k * 2];
    }
}