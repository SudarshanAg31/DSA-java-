class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        while (j < s.length()) {
            if (!mp.containsKey(s.charAt(j)))
                mp.put(s.charAt(j), 1);
            else
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            while (mp.get(s.charAt(j)) > 2) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}