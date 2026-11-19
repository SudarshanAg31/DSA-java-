class Solution {
    public int fun(String s1, String s2, int i, int j, int[][] dp) {
       if(i == s1.length() || j == s2.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + fun(s1, s2, i+1, j+1, dp);
        }
        return dp[i][j] = Math.max(
            fun(s1, s2, i+1, j, dp),
            fun(s1, s2, i, j+1, dp)
        );
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        fun(str1, str2, 0, 0, dp);
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while(i < n && j < m) {
            if(str1.charAt(i) == str2.charAt(j)) {
                ans.append(str1.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] >= dp[i][j+1]) {
                ans.append(str1.charAt(i));
                i++;
            }
            else {
                ans.append(str2.charAt(j));
                j++;
            }
        }
        while(i < n)
            ans.append(str1.charAt(i++));
        while(j < m)
            ans.append(str2.charAt(j++));
        return ans.toString();
    }
}
