class Solution {
    public int expend(String s,int st,int ed){
        while(st>=0&&ed<s.length()&&s.charAt(st)==s.charAt(ed)){
            st--;
            ed++;
        }
        return ed-st-1;
    }
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int odd=expend(s,i,i);
            int even=expend(s,i,i+1);
            int max=Math.max(odd,even);
            if(max>end-start){
                start=i-(max-1)/2;
                end=i+max/2;
            }
        }
        return s.substring(start,end+1);
    }
}