class Solution {
    public void r_to_l(TreeNode root, int n, ArrayList<Integer>arr){
        if(root==null) return ;
        if(n==1){
            arr.add(root.val);
            return ;
        }
        r_to_l(root.left,n-1,arr);
        r_to_l(root.right,n-1,arr);
    }
    public void l_to_r(TreeNode root, int n,ArrayList<Integer>arr){
        if(root==null) return ;
        if(n==1){
            arr.add(root.val);
            return ;
        }
        l_to_r(root.right,n-1,arr);
        l_to_r(root.left,n-1,arr);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        int x=height(root);
        for(int i=1;i<=x;i++){
            ArrayList<Integer>arr=new ArrayList<>();
            if(i%2==1)r_to_l(root,i,arr);
            else l_to_r(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}