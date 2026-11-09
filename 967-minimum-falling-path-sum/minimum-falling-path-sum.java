class Solution {
    int[][]dp=new int [101][101];
    public int fun(int [][]mtx,int i,int j){
        if(mtx.length==i){
            return 0;
        }
        if(dp[i][j]!=-101)return dp[i][j];
        int down=mtx[i][j]+fun(mtx,i+1,j); 
        int rightdown=Integer.MAX_VALUE/2; 
        int leftdown=Integer.MAX_VALUE/2; 
        if(j-1>=0)
        leftdown=mtx[i][j]+fun(mtx,i+1,j-1); 
        if(j+1<mtx.length)
        rightdown=mtx[i][j]+fun(mtx,i+1,j+1); 
        return dp[i][j]=Math.min(down,Math.min(rightdown,leftdown));
    }
    public int minFallingPathSum(int[][] mtx) {
        for(int[]row: dp){
            Arrays.fill(row,-101);
        }
        int max=Integer.MAX_VALUE;
        for(int j=0;j<mtx[0].length;j++){
            max=Math.min(max,fun(mtx,0,j));
        }
        return max;
    }
}