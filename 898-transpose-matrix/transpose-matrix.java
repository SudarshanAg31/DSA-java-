class Solution {
    public int[][] transpose(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        int [][]t=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                t[j][i]=arr[i][j];
            }
        }
        return t;
    }
}