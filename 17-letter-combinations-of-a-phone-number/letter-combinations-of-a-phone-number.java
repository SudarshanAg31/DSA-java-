class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String>ans=new ArrayList<>();
        fun("",digits,ans);
        return ans;
    }
    String [] str={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void fun(String p,String up,ArrayList<String>ans){
        if(up.isEmpty()){
            ans.add(p);
            return;
        }
        int d=up.charAt(0)-'0';
        String letter=str[d]; 
        for(int i=0;i<letter.length();i++){
            fun(p+letter.charAt(i),up.substring(1),ans);
        }
    } 
}