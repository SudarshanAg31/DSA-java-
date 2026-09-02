class Solution {
    public boolean check(String s){
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }
    public void fun(List<List<String>> ans , ArrayList<String> list , String s , int i){
        if(i==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j = i ; j<s.length() ; j++){
            if(check(s.substring(i , j+1))==true){
                list.add(s.substring(i , j+1));
                fun(ans , list , s , j+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        fun(ans , list , s , 0);
        return ans;
    }
}