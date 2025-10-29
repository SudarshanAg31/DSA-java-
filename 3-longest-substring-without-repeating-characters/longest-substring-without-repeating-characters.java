class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();
        if(s.length()==1)return 1;
        if(s==null)return 0; 
        int max=0;
        int r=0;
        int l=0;
        while(r<s.length()){
            char a=s.charAt(r);
            while(st.contains(a)){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(a);
            r++;
            if(st.size()>max){
                max=st.size();
            }
        }
        return max;   
    }
}