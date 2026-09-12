class Solution {
    public boolean bfs(List<List<Integer>>adj,int s,int d){
        boolean[] vis=new boolean [adj.size()+1];
        Queue<Integer>q=new ArrayDeque<>();
        q.add(s);
        vis[s]=true;
        while(!q.isEmpty()){
            int temp=q.remove();
            if(vis[d])return true;
            for(int i:adj.get(temp)){
                if(!vis[i]){
                    q.add(i);
                    vis[i]=true;
                }
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for (int i = 0; i <=edges.length ; i++) {
            adj.add(new ArrayList<>());
        }
        int[]ans=new int [2];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(bfs(adj,u,v)){
                ans[0]=u;
                ans[1]=v;
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return ans;
    }
}