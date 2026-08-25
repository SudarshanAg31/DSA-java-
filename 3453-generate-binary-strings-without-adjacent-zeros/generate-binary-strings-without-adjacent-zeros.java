class Solution {
    public void fun(int n, String s, int a, List<String> ans) {
        if (a == n) {
            ans.add(s);
            return;
        }
        fun(n, s + "1", a + 1, ans);
        if (s.length() == 0 || s.charAt(s.length() - 1) == '1')
            fun(n, s + "0", a + 1, ans);
    }

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        fun(n, "", 0, ans);
        return ans;
    }
}