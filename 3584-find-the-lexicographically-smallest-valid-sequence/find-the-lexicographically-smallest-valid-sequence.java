class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] arr = new int[n];
        int[] ans = new int[m];
        int j = m - 1;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                count++;
                j--;
            }
            arr[i] = count;
        }
        j = 0;
        int i = 0;
        int a = 0;
        boolean flag = false;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                j++;
                ans[a++] = i;
            } else if (i + 1 < n && flag == false && arr[i + 1] >= m - j - 1) {
                ans[a++] = i;
                j++;
                flag = true;
            }
            i++;
        }
        if (j == m)
            return ans;
        return new int[0];
    }
}