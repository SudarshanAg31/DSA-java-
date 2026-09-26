class Solution {
    public boolean check(String temp) {
        if (temp.length() > 1 && temp.charAt(0) == '0') {
            return false;
        }
        int a = Integer.parseInt(temp);
        if (a >= 0 && a <= 255)
            return true;
        return false;
    }
    public void fun(String str, int i, String s, int dot,List<String> ans) {
        if (dot == 4) {
            if (i == s.length()) {
                ans.add(new String(str.substring(0,str.length()-1)));
            }
            return;
        }
        if (i == s.length()) {
            return;
        }
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            String temp = s.substring(i, j + 1);
            if (check(temp)) {
                fun(str+temp+".", j + 1, s,dot+1, ans);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        fun("", 0, s, 0,ans);
        return ans;
    }
}