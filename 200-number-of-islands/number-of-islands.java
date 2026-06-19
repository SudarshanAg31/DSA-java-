class ans{
    int x;
    int y;
    ans(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public void pos(int x,int y,char[][] grid,boolean[][]check,Queue<ans>q){
        int n=grid.length;
        int m=grid[0].length;
        int i=x;
        int j=y;
        //left to right
        j=y;
        i=x;
        j++;
        if(j<m&&!check[i][j]&&grid[i][j]=='1'){
            q.add(new ans(i,j));
            check[i][j]=true;
        }
        j=y;
        i=x;
        //right to left
        j--;
        if(j>=0&&!check[i][j]&&grid[i][j]=='1'){
            q.add(new ans(i,j));
            check[i][j]=true;
        }
        //top to bottom
        j=y;
        i=x;
        i++;
        if(i<n&&!check[i][j]&&grid[i][j]=='1'){
            q.add(new ans(i,j));
            check[i][j]=true;
        }
        //bottom to up
        j=y;
        i=x;
        i--;
        if(i>=0&&!check[i][j]&&grid[i][j]=='1'){
            q.add(new ans(i,j));
            check[i][j]=true;
        }
    }
    public void bfs(char[][] grid,boolean[][]check,int i,int j){
        Queue<ans>q=new LinkedList<>();
        q.add(new ans(i,j));
        check[i][j]=true;
        while(!q.isEmpty()){
            ans top=q.remove();
            int x=top.x;
            int y=top.y;
            pos(x,y,grid,check,q);
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][]check=new boolean[grid.length][grid[0].length];
        int x=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!check[i][j]&&grid[i][j]=='1'){
                    bfs(grid,check,i,j);
                    x++;
                }
            }
        }
        return x;
    }
}