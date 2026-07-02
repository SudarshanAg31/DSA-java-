class Solution {
    static int ans;

    public boolean check(int[][] mtx, int i, int j, int a, int b) {
        if (a >= mtx.length || b >= mtx[0].length)
            return false;
        for (int w = i; w <= a; w++) {
            for (int s = j; s <= b; s++) {
                if (mtx[w][s] != 1)
                    return false;
            }
        }
        return true;
    }

    public void fun(int[][] mtx, int i, int j) {
        int m = mtx.length;
        int n = mtx[0].length;
        if (j == n) {
            i += 1;
            j = 0;
        }
        if (i == m)
            return;
        if (i == m && j == n) {
            return;
        }
        if (mtx[i][j] != 0 && i <= m - 1 && j <= n - 1) {
            ans += 1;
            int a = i + 1;
            int b = j + 1;
            while (check(mtx, i, j, a, b)) {
                ans += 1;
                a++;
                b++;
            }
        }
        fun(mtx, i, j + 1);
    }

    public int countSquares(int[][] mtx) {
        //recursion
        // ans=0;
        // fun(mtx,0,0);
        // return ans;

        //tabulation 
        int m = mtx.length;
        int n = mtx[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int count = 0;
                boolean q = false;
                if (mtx[i][j] == 1) {
                    int a = i;
                    count++;
                    a++;
                    if (a < m && mtx[a][j] == 1) {
                        a = i;
                        int b = j;
                        b++;
                        if (b < n && mtx[a][b] == 1) {
                            a++;
                            if (b < n && a < m && mtx[a][b] == 1) {
                                dp[i][j] = count + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                                q = true;
                            }
                        }
                    }
                    if (!q)
                        dp[i][j] = count;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}