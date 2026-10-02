class Solution {
    public void fun(List<String>arr,String str,int n,int e,int i){
        if(str.length()==n*2){
            arr.add(new String(str));
            return ;
        }
        if(i<n){
            fun(arr,str+"(",n,e,i+1);
        }
        if(e<i){
            fun(arr,str+")",n,e+1,i);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> arr=new ArrayList<>();
        fun(arr,"",n,0,0);
        return arr;
    }
}