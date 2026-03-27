class Solution {
    public void level(TreeNode root,int n,ArrayList<Integer>arr){
        if(root==null) return ;
        if(n==1){
            arr.add(root.val);
            return ;
        }
        level(root.left,n-1,arr);
        level(root.right,n-1,arr);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int x=height(root);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=x;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            level(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}