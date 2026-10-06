class Solution {
    public int fun(String s, String t, int i, int j, int[][] dp) {
        if (t.length() == j) {
            return 1;
        }
        if (s.length() == i)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int take = 0;
        if (s.charAt(i) == t.charAt(j))
            take = fun(s, t, i + 1, j + 1, dp);
        int skip = fun(s, t, i + 1, j, dp);
        return dp[i][j] = take + skip;
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(s, t, 0, 0, dp);
    }
}