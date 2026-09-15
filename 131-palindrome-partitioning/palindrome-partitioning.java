class Solution {
    public boolean check(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }
    public void fun(String s,List<List<String>>ans,int i,List<String>temp){
        if(i==s.length()){
            ans.add(new ArrayList(temp));
            return;    
        }
        for(int j=i;j<s.length();j++){
            String str=s.substring(i,j+1);
            if(check(str)){
                temp.add(str);
                fun(s,ans,j+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        fun(s,ans,0,temp);
        return ans;
    }
}