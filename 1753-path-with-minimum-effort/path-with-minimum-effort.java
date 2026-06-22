class trip implements Comparable<trip>{
    int r;
    int c;
    int dis;
    trip(int r ,int c,int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
    public int compareTo(trip d) {
            return this.dis - d.dis;
        }
}
class Solution {
    public int minimumEffortPath(int[][] temp) {
        int [][]arr=new int [temp.length][temp[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=Integer.MAX_VALUE;
            }
        }
        arr[0][0]=0;
        PriorityQueue<trip>q=new PriorityQueue<>();
        q.add(new trip(0,0,0));
        while(!q.isEmpty()){
            trip top=q.remove();
            int row=top.r;
            int col=top.c;
            int dis=top.dis;
            //top
            if(row==arr.length-1&&col==arr[0].length-1){
                break;
            }
            if(row-1>=0){
                int x=Math.abs(temp[row][col]-temp[row-1][col]);
                int max=Math.max(dis,x);
                if(max<arr[row-1][col]){
                    arr[row-1][col]=max;
                    q.add(new trip(row-1,col,max));
                }                
            }
            //bottom
            if(row+1<arr.length){
                int x=Math.abs(temp[row][col]-temp[row+1][col]);
                int max=Math.max(dis,x);
                if(max<arr[row+1][col]){
                    arr[row+1][col]=max;
                    q.add(new trip(row+1,col,max));
                }
            }
            //left
            if(col-1>=0){
                int x=Math.abs(temp[row][col]-temp[row][col-1]);
                int max=Math.max(dis,x);
                if(max<arr[row][col-1]){
                    arr[row][col-1]=max;
                    q.add(new trip(row,col-1,max));
                }
            }
            //right
            if(col+1<arr[0].length){
                int x=Math.abs(temp[row][col]-temp[row][col+1]);
                int max=Math.max(dis,x);
                if(max<arr[row][col+1]){
                    arr[row][col+1]=max;
                    q.add(new trip(row,col+1,max));
                }
            }
        }
        return arr[arr.length-1][arr[0].length-1];
    }
}