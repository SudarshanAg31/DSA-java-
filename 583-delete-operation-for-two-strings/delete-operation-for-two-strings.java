class Solution {
    public int fun(int i, int j, StringBuilder s, StringBuilder a, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == a.charAt(j)) {
            return dp[i][j] = 1 + fun(i - 1, j - 1, s, a, dp);
        } else {
            return dp[i][j] = Math.max(fun(i, j - 1, s, a, dp), fun(i - 1, j, s, a, dp));
        }
    }

    public int minDistance(String word1, String word2) {
        StringBuilder s = new StringBuilder(word1);
        StringBuilder a = new StringBuilder(word2);
        int[][] dp = new int[s.length()][a.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                dp[i][j] = -1;
            }
        }
        int max = fun(s.length() - 1, a.length() - 1, s, a, dp);
        return a.length() - max + s.length() - max;
    }
}