
// ye code tere bhai ne kiya tha ladle 
class Solution {
    public boolean helper(char[][] arr , String word , int m , int n , int i , boolean[][]visit , int row  , int col){
        if(i==word.length()){
            return true;
        }
        char ch = word.charAt(i); // agla wala
        boolean right = false , down = false , left = false  , up = false;
        visit[row][col] = true;
        // right
        if(col<n-1 && arr[row][col+1]==ch && visit[row][col+1]==false){
           right =  helper(arr , word , m , n , i+1 , visit , row , col+1);
        }
        // down
        if(row<m-1 && arr[row+1][col]==ch && visit[row+1][col]==false){
            down = helper(arr , word , m , n , i+1 , visit , row+1 , col);
        }
        // left
        if(col>0 && arr[row][col-1]==ch && visit[row][col-1]==false){
            left = helper(arr , word , m , n , i+1 , visit , row , col-1);
        }
        // up
        if(row>0 && arr[row-1][col]==ch && visit[row-1][col]==false){
           up =  helper(arr , word , m , n , i+1 , visit , row-1 , col);
        }
        visit[row][col] = false;
        return right || down || left || up;
    }
    public boolean exist(char[][] arr, String word) {
        int m = arr.length;
        int n = arr[0].length;
        boolean[][]visit = new boolean[m][n];
        boolean ans = false;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(arr[i][j]==word.charAt(0)){
                    ans = helper(arr, word , m , n , 1 , visit , i , j);
                    if(ans==true) return ans;
                }
            }
        }
        return ans;
    }
}