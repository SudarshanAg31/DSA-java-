class Solution {
    public void fun(TreeNode root,List<Integer>ans){
        if(root==null){
            return;
        }
        fun(root.left,ans);
        ans.add(root.val);
        fun(root.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        fun(root,ans);
        return ans;
    }
}