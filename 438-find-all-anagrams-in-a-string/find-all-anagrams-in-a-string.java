class Solution {
    public List<Integer> findAnagrams(String s, String p) {
               List<Integer>arr=new ArrayList<>();
       if(p.length()>s.length())return arr;
        int[] p_arr=new int[26];
        int[] s_arr=new int[26];
        for(int i=0;i<p.length();i++){
            p_arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            s_arr[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(p_arr,s_arr))arr.add(0);
        int i=0;
        for(int e=p.length();e<s.length();e++){
            s_arr[s.charAt(e)-'a']++;
            s_arr[s.charAt(i)-'a']--;
            if(Arrays.equals(s_arr,p_arr))arr.add(i+1);
            i++;
        }
        return arr;
    }
}