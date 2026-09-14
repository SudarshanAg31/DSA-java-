class Solution {
    String ans = "";
    int count = 0;
    public void swap(int i, int j, StringBuilder str) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }
    public void sort(StringBuilder str, int i) {
        for (int a = i; a < str.length(); a++) {
            for (int b = a + 1; b < str.length(); b++) {
                if (str.charAt(a) > str.charAt(b)) {
                    swap(a, b, str);
                }
            }
        }
    }
    public void fun(int n, int k, int i, StringBuilder str) {
        if (i == str.length()) {
            count++;
            if (count == k) {
                ans = str.toString();
            }
            return;
        }
        sort(str, i);
        for (int j = i; j < n; j++) {
            StringBuilder next = new StringBuilder(str);
            swap(i, j, next);
            fun(n, k, i + 1, next);
            if (count == k) {
                return;
            }
        }
    }

    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }
        fun(n, k, 0, str);
        return ans;
    }
}
