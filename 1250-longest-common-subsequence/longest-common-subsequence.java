class Solution {
    public int fun(int i, int j, StringBuilder text1, StringBuilder text2, int[][] dp) {
        if (i == -1 || j == -1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + fun(i - 1, j - 1, text1, text2, dp);
        } else {
            return dp[i][j] = Math.max(fun(i - 1, j, text1, text2, dp), fun(i, j - 1, text1, text2, dp));
        }
    }

    public int longestCommonSubsequence(String a, String b) {
        StringBuilder text1 = new StringBuilder(a);
        StringBuilder text2 = new StringBuilder(b);
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return fun(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }
}