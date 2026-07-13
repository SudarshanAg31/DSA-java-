class Solution {
    public int kthSmallest(int[][] mtx, int k) {
        int n=mtx.length;
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        int i=1;
        int a=0;
        int b=0;
        while(i<=k){
            q.add(mtx[a][b]);
            b++;
            if(b==n){
                a++;
                b=0;
            }
            i++;
        }
        while(i<=n*n){
            q.add(mtx[a][b]);
            q.remove();
            b++;
            if(b==n){
                a++;
                b=0;
            }
            i++;
        }
        return q.peek();
    }
}