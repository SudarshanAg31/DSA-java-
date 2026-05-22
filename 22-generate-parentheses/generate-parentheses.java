class Solution {
    public void fun(int n,String str,List<String> ans,int s,int e){
        if(str.length()==n*2){
            ans.add(str);
            return ;
        }
        if(s<n){
            fun(n,str+"(",ans,s+1,e);
        }
        if(e<s){
            fun(n,str+")",ans,s,e+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        fun(n,"",ans,0,0);
        return ans;
    }
}