
class Solution {
    public boolean fun(TreeNode root,TreeNode root1){
        if(root==null)return false;
        if(root==root1)return true;
        return fun(root.left,root1)||fun(root.right,root1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root||q==root)return root;
        boolean left=fun(root.left,p);
        boolean right=fun(root.right,q);
        if(left && !right)return lowestCommonAncestor(root.left,p,q);
        if(!left && right)return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}