class Solution {
    public int fun(int i, int j, String s, String s2, int[][] dp) {
        if (i == -1 || j == -1) {
            if (i == -1) {
                return j + 1;
            } else
                return i + 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = fun(i - 1, j - 1, s, s2, dp);
        } else {
            //delete 
            int del = 1 + fun(i - 1, j, s, s2, dp);
            //insert
            int inst = 1 + fun(i, j - 1, s, s2, dp);
            //replace
            int rep = 1 + fun(i - 1, j - 1, s, s2, dp);
            return dp[i][j] = Math.min(del, Math.min(inst, rep));
        }

    }

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return fun(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }
}