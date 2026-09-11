class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] updateMatrix(int[][] mtx) {
        int [][]vis=new int [mtx.length][mtx[0].length];
        Queue<pair>q=new ArrayDeque<>();
       for(int i=0;i<mtx.length;i++){
        for(int j=0;j<mtx[0].length;j++){
            if(mtx[i][j]==0){
                q.add(new pair(i,j));
            }
            else{
                vis[i][j]=-1;
            }
        }
       }
       while(!q.isEmpty()){
        pair temp=q.remove();
        int i=temp.row;
        int j=temp.col;
        //up
        if(i-1>=0&&vis[i-1][j]==-1){
            vis[i-1][j]=vis[i][j]+1;
            q.add(new pair(i-1,j));
        }
        //down
        if(i+1<mtx.length&&vis[i+1][j]==-1){
            vis[i+1][j]=vis[i][j]+1;
            q.add(new pair(i+1,j));
        }
        //left
        if(j-1>=0&&vis[i][j-1]==-1){
            vis[i][j-1]=vis[i][j]+1;
            q.add(new pair(i,j-1));
        }
        //right
        if(j+1<mtx[0].length&&vis[i][j+1]==-1){
            vis[i][j+1]=vis[i][j]+1;
            q.add(new pair(i,j+1));
        }
       }
       return vis; 
    }
}