class trip implements Comparable<trip> {
    int n;
    int p;
    int dst;
    trip(int n, int p, int dst) {
        this.n = n;
        this.p = p;
        this.dst = dst;
    }
    public int compareTo(trip d) {
        return this.dst - d.dst;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<trip>q=new PriorityQueue<>();
        boolean[]check=new boolean[points.length];
        q.add(new trip(0,-1,0));
        int sum=0;
        while(!q.isEmpty()){
            trip top=q.remove();
            int c=top.n;
            int p=top.p;
            int d=top.dst;
            if(check[c]==true)continue;
            sum+=d;
            check[c]=true;
            for(int i=0;i<points.length;i++){
                if(i==c)continue;
                if(i==p)continue;
                if(check[i]==true)continue;
                int x=points[c][0],y=points[c][1];
                int x1=points[i][0],y1=points[i][1];
                int dis=Math.abs(x1-x)+Math.abs(y1-y);
                q.add(new trip(i,c,dis));
            }
        }
        return sum;
    }
}