class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int a=0;
        int b=0;
        int[][] arr = new int[n][n];
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = k;
            while (i < n && j < n) {
                if (k == 0) {
                    arr[i][j] = 1;
                    a=i;
                    b=j;
                }
                if (k == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        arr[i][j] = 1;
                    a=i;
                    b=j;
                    }
                }
                if (k > 1) {
                    if (s.charAt(i) == s.charAt(j) && arr[i + 1][j - 1] == 1) {
                        arr[i][j] = 1;
                    a=i;
                    b=j;
                    }
                }
                i++;
                j++;
            }
        }
        return s.substring(a,b+1);
    }
}