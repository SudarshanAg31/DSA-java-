
class Solution {
        public void fun(TreeNode root,List<Integer>ans){
        if(root==null){
            return;
        }
        fun(root.left,ans);
        fun(root.right,ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        fun(root,ans);
        return ans;
    }
}