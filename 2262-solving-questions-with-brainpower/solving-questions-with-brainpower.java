class Solution {
    public long fun(int[][] questions, int i, long[] dp) {
        if (questions.length <= i) {
            return 0;
        }
        long take = Long.MIN_VALUE;
        long skip = Long.MIN_VALUE;
        if (dp[i] != -1)
            return dp[i];
        take = questions[i][0] + fun(questions, i + questions[i][1] + 1, dp);
        skip = fun(questions, i + 1, dp);
        return dp[i] = Math.max(take, skip);
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);
        return fun(questions, 0, dp);
    }
}