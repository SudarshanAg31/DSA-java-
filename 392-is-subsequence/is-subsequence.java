class Solution {
    public boolean fun(String s, String t,int i,int j){
        if(s.length()==i)return true;
        if(t.length()==j)return false;
        boolean take=true;
        boolean skip=true;
        if(s.charAt(i)==t.charAt(j))
        take=fun(s,t,i+1,j+1);
        else{
        skip=fun(s,t,i,j+1);
        }
        return take&&skip;
    }
    public boolean isSubsequence(String s, String t) {
        return fun(s,t,0,0);
    }
}