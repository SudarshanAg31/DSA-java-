class Solution {
    class pair{
        int i;
        int j;
        pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        Queue<pair>q=new ArrayDeque<>();
        boolean[][] vis=new boolean [n][n];
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        q.add(new pair(0,0));
        vis[0][0]=true;
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
            pair temp=q.remove();
            if(temp.i==n-1&&temp.j==n-1)return count;
            //up
            if(temp.i-1>=0&&!vis[temp.i-1][temp.j]&&grid[temp.i-1][temp.j]==0){
                vis[temp.i-1][temp.j]=true;
                q.add(new pair(temp.i-1,temp.j));
            }
            //down
            if(temp.i+1<n&&!vis[temp.i+1][temp.j]&&grid[temp.i+1][temp.j]==0){
                vis[temp.i+1][temp.j]=true;
                q.add(new pair(temp.i+1,temp.j));
            }
            //left
            if(temp.j-1>=0&&!vis[temp.i][temp.j-1]&&grid[temp.i][temp.j-1]==0){
                vis[temp.i][temp.j-1]=true;
                q.add(new pair(temp.i,temp.j-1));
            }
            //right
            if(temp.j+1<n&&!vis[temp.i][temp.j+1]&&grid[temp.i][temp.j+1]==0){
                vis[temp.i][temp.j+1]=true;
                q.add(new pair(temp.i,temp.j+1));
            }
            //up right
            if(temp.i-1>=0&&temp.j+1<n&&!vis[temp.i-1][temp.j+1]&&grid[temp.i-1][temp.j+1]==0){
                vis[temp.i-1][temp.j+1]=true;
                q.add(new pair(temp.i-1,temp.j+1));
            }
            //up left
            if(temp.i-1>=0&&temp.j-1>=0&&!vis[temp.i-1][temp.j-1]&&grid[temp.i-1][temp.j-1]==0){
                vis[temp.i-1][temp.j-1]=true;
                q.add(new pair(temp.i-1,temp.j-1));
            }
            //down right
            if(temp.i+1<n&&temp.j+1<n&&!vis[temp.i+1][temp.j+1]&&grid[temp.i+1][temp.j+1]==0){
                vis[temp.i+1][temp.j+1]=true;
                q.add(new pair(temp.i+1,temp.j+1));
            }
            //down left
            if(temp.i+1<n&&temp.j-1>=0&&!vis[temp.i+1][temp.j-1]&&grid[temp.i+1][temp.j-1]==0){
                vis[temp.i+1][temp.j-1]=true;
                q.add(new pair(temp.i+1,temp.j-1));
            }
            }
            count++;
        }
        return -1;
    }
}