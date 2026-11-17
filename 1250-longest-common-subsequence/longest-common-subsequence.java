class Solution {
    public int fun(int i,int j,String str1,String str2,int[][]dp){
        if(i==str1.length()||j==str2.length()){
            return 0;
        }
        int match=0,check1=0,check2=0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(str1.charAt(i)==str2.charAt(j)){
            match=1+fun(i+1,j+1,str1,str2,dp);
        }
        if(str1.charAt(i)!=str2.charAt(j)){
            check1=fun(i+1,j,str1,str2,dp);
            check2=fun(i,j+1,str1,str2,dp);
        }
        return dp[i][j]=match+Math.max(check1,check2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()][text2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(0,0,text1,text2,dp);
    }
}