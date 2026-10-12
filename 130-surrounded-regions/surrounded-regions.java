class Solution {
    public void fun(int i,int j,boolean[][]vis,char [][]board){
        vis[i][j]=true;
        //up
        if(i-1>=0&&!vis[i-1][j]&&board[i-1][j]=='O'){
            fun(i-1,j,vis,board);
        }
        // down
        if(i+1<board.length&&!vis[i+1][j]&&board[i+1][j]=='O'){
            fun(i+1,j,vis,board);
        }
        // left
        if(j-1>=0&&!vis[i][j-1]&&board[i][j-1]=='O'){
            fun(i,j-1,vis,board);
        }
        //right
        if(j+1<board[0].length&&!vis[i][j+1]&&board[i][j+1]=='O'){
            fun(i,j+1,vis,board);
        }
    }
    public void solve(char[][] board) {
        boolean[][]vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0||i==board.length-1||j==0||j==board[0].length-1){
                    if(board[i][j]=='O'&&!vis[i][j]){
                        fun(i,j,vis,board);
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(vis[i][j]){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
}