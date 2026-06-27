class Solution {
    static int[] p;
    static int[] size;
    public int find(int a){
        if(p[a]==a)return a;
        int leader=find(p[a]);
        p[a]=leader;
        return leader;
    }
    public void union(int i,int j){
        int a=find(i);
        int b=find(j);
        if(a!=b){
            if(size[a]>size[b]){
                p[b]=a;
                size[a]+=size[b];
            }
            else{
                p[a]=b;
                size[b]+=size[a];
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        p=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<n+1;i++){
            p[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+1!=j+1&&isConnected[i][j]==1)
                union(i+1,j+1);
            }
        }
        int count=0;
        for(int i=1;i<n+1;i++){
            if(p[i]==i)count++;
        }
        return count;
    }
}