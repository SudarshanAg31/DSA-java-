class Solution {
    class pair {
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair>q=new ArrayDeque<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int count=0;
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
            pair temp=q.remove();
            int row=temp.row;
            int col=temp.col;
            //check up
            if(row-1>=0&&grid[row-1][col]!=2&&grid[row-1][col]==1){
                q.add(new pair(row-1,col));
                grid[row-1][col]=2;
                fresh--;
            }
            //check down
            if(row+1<n&&grid[row+1][col]!=2&&grid[row+1][col]==1){
                q.add(new pair(row+1,col));
                grid[row+1][col]=2;
                fresh--;
            }
            //check left
            if(col-1>=0&&grid[row][col-1]!=2&&grid[row][col-1]==1){
                q.add(new pair(row,col-1));
                grid[row][col-1]=2;
                fresh--;
            }
            //check right
            if(col+1<m&&grid[row][col+1]!=2&&grid[row][col+1]==1){
                q.add(new pair(row,col+1));
                grid[row][col+1]=2;
                fresh--;
                }
            }
            count++;
        }
        if(fresh!=0)return -1;
        return count;
    }
}