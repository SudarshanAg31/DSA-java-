class Solution {
    public boolean check(int [][]mtx,int i,int j){
        if(i+1<mtx.length){
            if(mtx[i][j]<=mtx[i+1][j]){
            return false;
            }
        }
        if(i-1>=0){
            if(mtx[i][j]<=mtx[i-1][j]){
            return false;
            }
        }
        if(j+1<mtx[0].length){
            if(mtx[i][j]<=mtx[i][j+1]){
            return false;
            }
        }
        if(j-1>=0){
            if(mtx[i][j]<=mtx[i][j-1]){
            return false;
            }
        }
        return true;
    }
    public int[] findPeakGrid(int[][] mtx) {
        int[] ans=new int [2];
        ans[0]=1;
        for(int i=0;i<mtx.length;i++){
            int s=0;
            int e=mtx[0].length-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(check(mtx,i,mid)){
                    ans[0]=i;
                    ans[1]=mid;
                    return ans;
                } 
                if(mid+1<mtx[0].length&&mtx[i][mid]<=mtx[i][mid+1]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return ans;
    }
}