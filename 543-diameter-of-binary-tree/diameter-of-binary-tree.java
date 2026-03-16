class Solution {
    public int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        int a=diameterOfBinaryTree(root.left);
        int b=diameterOfBinaryTree(root.right);
        int mid=height(root.left)+height(root.right);
        if(root.right!=null)mid++;
        if(root.left!=null)mid++;
        int max= Math.max(a,Math.max(b,mid));
        return max;
    }
}