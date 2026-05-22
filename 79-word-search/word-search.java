class Solution {
    public boolean isvalid(char[][] board,int row,int col ,
                            String word,int idx){

        int n=board.length;
        int nn=board[0].length;

        if(idx==word.length()) return true;

        char ch=word.charAt(idx);

        char temp=board[row][col];
        board[row][col]='X';

        // up
        int i=row-1;
        int j=col;
        if(i>=0&&ch==board[i][j]){
            if(isvalid(board,i,j,word,idx+1)){
                board[row][col]=temp;
                return true;
            }
        }

        // down
        i=row+1;
        j=col;
        if(i<n&&ch==board[i][j]){
            if(isvalid(board,i,j,word,idx+1)){
                board[row][col]=temp;
                return true;
            }
        }

        // left
        i=row;
        j=col-1;

        if(j>=0&&ch==board[i][j]){
            if(isvalid(board,i,j,word,idx+1)){
                board[row][col]=temp;
                return true;
            }
        }
        // right
        i=row;
        j=col+1;
        if(j<nn&&ch==board[i][j]){
            if(isvalid(board,i,j,word,idx+1)){
                board[row][col]=temp;
                return true;
            }
        }

        board[row][col]=temp;
        return false;
    }

    public boolean fun(char[][] board,String word,
                       int row,int col){

        if(col==board[0].length){
            row++;
            col=0;
        }

        if(row==board.length)
            return false;

        if(board[row][col]==word.charAt(0)){
            if(isvalid(board,row,col,word,1))
                return true;
        }

        return fun(board,word,row,col+1);
    }

    public boolean exist(char[][] board,String word){
        return fun(board,word,0,0);
    }
}