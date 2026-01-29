class Solution {
    public String reverseWords(String s) {
       StringBuilder ans=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            if (i<0) break;
            int end=i;
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            int start=i+1;
            ans.append(s.substring(start,end+1));
            ans.append(" ");
        }
        String solve=ans.toString();
        solve=solve.substring(0,solve.length()-1);
        return solve;
    }
}