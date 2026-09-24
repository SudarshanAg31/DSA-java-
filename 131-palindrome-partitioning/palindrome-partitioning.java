class Solution {
    public boolean check(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))return false;
        }
        return true;
    }
    public void fun(int i,String s,List<List<String>>ans, List<String>temp){
        if(s.length()==i){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int j=i;j<s.length();j++){
            String sub=s.substring(i,j+1);
            if(check(sub)){
                temp.add(sub);
                fun(j+1,s,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        fun(0,s,ans,temp);
        return ans;
    }
}