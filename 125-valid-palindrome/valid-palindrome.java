class Solution {
    public boolean alphanumaric(char i){
        if((i>='0'&&i<='9')||(i>='a'&&i<='z')){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String sa) {
        String s=sa.toLowerCase();
        int sr=0;
        int e=s.length()-1;
        while(sr<e){
            while((sr<e)&&(!alphanumaric(s.charAt(sr)))){
                sr++;
            }
            while((sr<e)&&(!alphanumaric(s.charAt(e)))){
                e--;
            }
            if(s.charAt(sr)!=s.charAt(e)){
                return false;
            }
            sr++;
            e--;
        }
        return true;
    }
}