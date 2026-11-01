class Solution {
    public int fun(int i, String s, int[] dp) {
        if (i == s.length()) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        int take = fun(i + 1, s, dp);
        int take2 = 0;
        if (i + 1 < s.length()) {
            int convert = s.charAt(i + 1) - '0';
            if (s.charAt(i) == '1' || (s.charAt(i) == '2' && convert <= 6)) {
                take2 = fun(i + 2, s, dp);
            }
        }
        return dp[i] = take + take2;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        // Arrays.fill(dp,-1);
        // return fun(0, s,dp);
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            int take = dp[i + 1];
            int take2 = 0;
            if (i + 1 < s.length()) {
                int convert = s.charAt(i + 1) - '0';
                if (s.charAt(i) == '1' || (s.charAt(i) == '2' && convert <= 6)) {
                    take2 = dp[i + 2];
                }
            }
            dp[i] = take + take2;
        }
        return dp[0];
    }
}