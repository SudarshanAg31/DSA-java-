class Solution {
    public int numberOfSubstrings(String str) {
        int s = 0;
        int e = 0;
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (s < str.length()) {
            char ch = str.charAt(s);
            if (!mp.containsKey(ch))
                mp.put(ch, 1);
            else
                mp.put(ch, mp.get(ch) + 1);
            while (mp.size() == 3) {
                count += str.length() - s;
                if (mp.containsKey(str.charAt(e)))
                    mp.put(str.charAt(e), mp.get(str.charAt(e)) - 1);
                if (mp.get(str.charAt(e)) == 0) {
                    mp.remove(str.charAt(e));
                }
                e++;
            }
            s++;
        }
        return count;
    }
}