class Solution {
    public String minWindow(String str, String t) {
        if (str.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!need.containsKey(ch)) {
                need.put(ch, 1);
            } else {
                need.put(ch, need.get(ch) + 1);
            }
        }
        Map<Character, Integer> window = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        String ans="";
        int count = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (need.containsKey(ch)) {
                if (!window.containsKey(ch)) {
                    window.put(ch, 1);
                } 
                else {
                    window.put(ch, window.get(ch) + 1);
                }
                if (window.get(ch) <= need.get(ch)) {
                    count++;
                }
            }
            temp.append(ch);
            while (count == t.length()) {
                if (temp.length() < minLength) {
                    ans= temp.toString();
                    minLength= temp.length();
                }
                char leftChar = str.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar) <= need.get(leftChar)) {
                        count--;
                    }
                    window.put(leftChar,window.get(leftChar) - 1);
                }
                temp.deleteCharAt(0);
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return ans;
    }
}