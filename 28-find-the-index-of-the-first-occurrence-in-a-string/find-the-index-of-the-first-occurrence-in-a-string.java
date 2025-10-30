class Solution {
    public int strStr(String str, String ans) {
        if(str.length()<ans.length())return -1;
        if(ans.length()==0)return 0;
        for(int i=0;i<=str.length()-ans.length();i++){
        int j=0;
        int k=i;
        while(j<ans.length()&&str.charAt(k)==ans.charAt(j)){
            k++;
            j++;
        }
        if(j==ans.length())return i;
        }
        return -1;
    }
}