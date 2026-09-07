class Solution {
    static boolean ans=false;
    public boolean check(int i,int j,int l,boolean[][] vis,char[][] board, String word){
        if(l==word.length()){
            ans=true;
            return true;
            }
        //left
        int a=i;
        int b=j-1;
        if(0<=b&&!vis[a][b]){
            char ch=board[a][b];
            if(ch==word.charAt(l)){
            vis[a][b]=true;
            if(check(i,j-1,l+1,vis,board,word)){
                return true;
            }
            vis[a][b]=false;
            }
        }
        //right
        a=i;
        b=j+1;
        if(b<board[0].length&&!vis[a][b]){
            char ch=board[a][b];
            if(ch==word.charAt(l)){
            vis[a][b]=true;
            if(check(i,j+1,l+1,vis,board,word)){
                return true;
            }
            vis[a][b]=false;
            }
        }
        //buttom
        a=i+1;
        b=j;
        if(a<board.length&&!vis[a][b]){
            char ch=board[a][b];
            if(ch==word.charAt(l)){
            vis[a][b]=true;  
            if(check(i+1,j,l+1,vis,board,word)){
                return true;
            }
            vis[a][b]=false;  
            }
        }
        a=i-1;
        b=j;
        if(a>=0&&!vis[a][b]){
            char ch=board[a][b];
            if(ch==word.charAt(l)){
            vis[a][b]=true;
            if(check(i-1,j,l+1,vis,board,word)){
                return true;
            }
            vis[a][b]=false;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis=new boolean [board.length][board[0].length];
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
               if(!vis[i][j]&&word.charAt(0)==board[i][j]){
                vis[i][j]=true;
                if(check(i,j,1,vis,board,word)&&ans){
                    return true;
                }
                vis[i][j]=false;
               }
            }
        }
        return false;
    }
}