class Solution {
    static int[]p;
    static int[]size;
    public int find(int a){
        if(p[a]==a)return a;
        int led=find(p[a]);
        p[a]=led;
        return led;
    }
    public void union(int i,int j,int ans[]){
        int a=find(i);
        int b=find(j);
        if(a==b){
            ans[0]=i;
            ans[1]=j;
        }
        else{
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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        p=new int[n+1];
        size=new int[n+1];
        for(int i=1;i<n+1;i++){
            p[i]=i;
            size[i]=1;
        }
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            union(edges[i][0],edges[i][1],ans);
        }
        return ans;
    }
}