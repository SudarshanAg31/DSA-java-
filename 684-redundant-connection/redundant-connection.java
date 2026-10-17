class DSU{
    int [] rank;
    int [] parent;
    DSU(int n){
        rank=new int[n+1];
        parent=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
    }
    public int find(int a){
        if(parent[a]==a){
            return parent[a];
        }
        parent[a]=find(parent[a]);
        return parent[a];
    }
    public boolean union(int a ,int b ){
        int root_a=find(a);
        int root_b=find(b);
        if(root_a==root_b){
            return false; 
        }
        if(rank[root_a]<rank[root_b]){
            parent[root_a]=root_b;
        }
        else if(rank[root_a]>rank[root_b]){
            parent[root_b]=root_a;
        }
        else{
            parent[root_a]=root_b;
            rank[root_a]++;
        }
        return true;
    }  
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU d=new DSU(edges.length);
        int[] ans=new int[2];
        for(int [] edge: edges){
            int u=edge[0];
            int v=edge[1];
            if(!d.union(u,v)){
                ans[0]=u;
                ans[1]=v;
            }
        }
        return ans;
    }
}
  