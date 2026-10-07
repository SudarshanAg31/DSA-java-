class Solution {
    int[] prev;
    int[] dp = new int[2001];
    int M = 1_000_000_007;
    public int fun(int n) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = (int)(((long) fun(n - 1) * 2) % M);
        if (prev[n] != 0) {
            int duplicate = fun(prev[n] - 1);
            total = (total - duplicate + M) % M;
        }
        return dp[n] = total;
    }
    public int distinctSubseqII(String s) {
        int n = s.length();
        prev = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] last = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx=s.charAt(i-1)-'a';
            prev[i]=last[idx];
            last[idx]=i;
        }
        return (fun(n) - 1 + M) % M;
    }
}