class Solution {
    public int fun(List<List<Integer>> triangle,int i,int j,int [][]dp){
        if(i==triangle.size()){
            return 0;
        }
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int take=triangle.get(i).get(j)+fun(triangle,i+1,j,dp);
        int take1=triangle.get(i).get(j)+fun(triangle,i+1,j+1,dp);
        return dp[i][j]=Math.min(take,take1);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][]dp=new int [201][201];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return fun(triangle,0,0,dp);
    }
}