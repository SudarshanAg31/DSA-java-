class Solution {
    public void fun(List<String> ans, String s, String temp, int i) {
        if (i == s.length()) {
            ans.add(temp);
            return;
        }
        if (Character.isDigit(s.charAt(i))) {
            fun(ans, s, temp + s.charAt(i), i + 1);
        } else {
            fun(ans, s, temp + Character.toLowerCase(s.charAt(i)), i + 1);
            fun(ans, s, temp + Character.toUpperCase(s.charAt(i)), i + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        fun(ans, s, "", 0);
        return ans;
    }
}