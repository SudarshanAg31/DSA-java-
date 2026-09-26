class Solution {
    int max = 0;

    public void fun(String s, int count, int i, Set<String> st) {
        if (count + (s.length() - i) <= max) {
            return;
        }
        if (i == s.length()) {
            max = Math.max(max, count);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String temp = s.substring(i, j + 1);
            if (!st.contains(temp)) {
                st.add(temp);
                fun(s, count + 1, j + 1, st);
                st.remove(temp);
            }
        }
    }

    public int maxUniqueSplit(String s) {
        Set<String> st = new HashSet<>();
        fun(s, 0, 0, st);
        return max;
    }
}