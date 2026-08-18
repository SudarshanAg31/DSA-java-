class Solution {
    public int fun(int i, int j, int[] cumsum, int[][] dp) {
        if (i >= j)
            return 0;
        int score = 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        for (int x = i; x <= j - 1; x++) {
            int leftsum = cumsum[x] - (i - 1 >= 0 ? cumsum[i - 1] : 0);
            int rightsum = cumsum[j] - cumsum[x];
            if (leftsum < rightsum) {
                score = Math.max(score, leftsum + fun(i, x, cumsum, dp));
            } else if (leftsum > rightsum) {
                score = Math.max(score, rightsum + fun(x + 1, j, cumsum, dp));
            } else {
                score = Math.max(score,
                        Math.max(leftsum + fun(i, x, cumsum, dp), rightsum + fun(x + 1, j, cumsum, dp)));
            }
        }
        return dp[i][j] = score;
    }

    public int stoneGameV(int[] stoneValue) {
        int[][] dp = new int[501][501];
        int n = stoneValue.length;
        int temp = 0;
        for (int i = 0; i < stoneValue.length; i++) {
            if (i == 0) {
                temp = stoneValue[i];
            } else {
                stoneValue[i] += temp;
            }
            temp = stoneValue[i];
        }
        return fun(0, n - 1, stoneValue, dp);
    }
}